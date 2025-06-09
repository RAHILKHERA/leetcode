package Week24_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 440 K-th smallest in lexicographical order. 
 * 
 * Problem Link:
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/?envType=daily-question&envId=2025-06-09
 * 
 * Input:
 * - Integer n
 * - Integer k
 * 
 * Constraints:
 * 1 <= k <= n <= 10^9
 *            
 * Task: Compute k th lexicographically smallest integer in the range [1,n].
 * 
 * Observations:
 * #1.  Generating lexicographical order of [1,n] :
 *  => Generate all the numbers starting from 1, then 2 and so on till 9. 
 *  => Only thing to keep is the generated number should be less than equal to n. 
 *  => As it is is decimal system, next range of numbers starting with particular number `x` can be found by `x * 10`
 *  => For example, 2 digit numbers starting with 1 is 10 to 19. So to move to next level multiply by 10 and to move in same level increment by 1. 
 *  => One way is to generate the k numbers in lexicographical way and return it. 
 *  => But this will fail, as the constraint are too high. 
 * #2. This can be visualized as Trie. 
 *  => Except first level, each node has 10 levels from 0 to 9, while first level has 9 options from 1 to 9 as leading 0's are not allowed. 
 *  => To move deeper in the trie, multiple node value with 10. 
 *  => To move in the same level of trie i.e. next branch of the trie, increase value of node by 1. 
 * #3. Instead of generating all the k numbers, following approach can be devised :
 *  => In a given branch, compute number of nodes that branch has, there are two cases
 *      -> Case 1 : If number of nodes in the branch are less than equal to k, then the whole branch can be skipped. 
 *      -> Case 2 : If number of nodes in the branch are greater than k, traverse that particular branch the depth in the level.
 * #4. Count the nodes that can be skipped :
 *  => Consider current branch and next branch, at each level the difference between number of nodes in current branch and next branch
 *  => provides total number of nodes in the current branch. 
 *  => Example current branch level node is 1, so next branch level node will be 2. 
 *  => Next level deeper in current branch will range from 10 to 19, while in next level next branch the range will be 20 to 29. 
 *  => So first level difference is 1 (2-1) and next level is 10 (20 - 10). Total number of nodes in current branch = 1 + 10 = 11. 
 *      -> This can be verified as follows lexicographical order from 1 to 20 is as follows :  
 *      -> [1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20].
 *      -> It is clear that in brach starting from 1 there are 11 nodes (The nodes before 2) 
 *      -> This proves over observation. 
 *  => The next branch always start from current + 1. Range goes till 10^9. So highest value of next can go till 10^9. 
 *     -> This will require long to store.    
 *  => There could be the case that next is over estimated. The largest value of next can be n + 1 as the largest value of current can be n. 
 *     -> So at every level, min(10 * next, n + 1) should be considered. 
 *    
 * Approach:
 * 1. Range of numbers is [1, n]
 *  => Intialized current number by 1. 
 *  => Reduce k by 1, as the already have 1 numeber, so  k - 1 numbers are required. 
 *  => Calcualte total number of numbers(nodes) `skippedCount` that can be skipped.
 *  => Case 1 : If skippedCount <= k, whole branch can be skipped. 
 *     -> The required k will be reduced by skippedCount. 
 *     -> Move to next branch by incrementing current number (equivalent to moving to sibling node in Trie).
 *  => Case 2 : If skippedCount > k, already have enough nodes. 
 *     -> Traverse down the branch, multiply current number by 10 (decimal system implies each node can have 10 child nodes).
 *     -> Reduce k by 1, as current number is also part of the order. 
 * 2. Number of nodes in a branch : 
 *  => current branch number, next branch number and value n. 
 *  => current branch number's maximum value can be n. `current` 
 *  => next branch number's maximum value can be n + 1. `next`
 *  => count at current level = next - current. 
 *  => move to next level by multiplying both current and next by 10. 
 *  => This can overestimate as next can go out of range as current is capped by n, next should be capped by n + 1. 
 *  => next = min (10*next, n + 1).       
 * 
 * Time Complexity: O(log n ^ 2)  
 *             
 * |                       Component                            |                Time               |
 * | ---------------------------------------------------------- |---------------------------------- |
 * | At each step either move to next sibling (node) or move    |  O(log n)                         |
 * | to next level by multiplying by 10. In worst case full trie|                                   |
 * | is traversed.                                              |                                   |
 * | To calculate number of nodes in each branch (internal loop)|  O(log n)                         |
 * | Move to next level by multiplying by 10.                   |                                   |
 * |------------------------------------------------------------|-----------------------------------|
 * |                  Total Complexity                          |  O(log n ^ 2)                     |
 * 
 * 
 * Space Complexity: O(1)
 * |                        Component                           |                  Space            |
 * | ---------------------------------------------------------- |---------------------------------- |
 * | No extra space proportional to input value is used.        |        O(1)                       |
 * |----------------------------------------------------------- |-----------------------------------|
 * | Total Complexity                                           |        O(1)                       |
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_440_KthSmallestInLexicographicalOrder {
    
    @Test
    public void test1() {
        assertEquals(10, findKthNumber(13, 2));
    }

    @Test
    public void test2() {
        assertEquals(1, findKthNumber(1, 1));
    }

    @Test
    public void test3() {
        assertEquals(2, findKthNumber(2, 2));
    }
    
    public int findKthNumber(int n, int k) {
        int currentNumber = 1;
        k--;
        while (k > 0) {
            long skipCount = skipCount(currentNumber, currentNumber + 1, n);
            if (skipCount <= k) {
                currentNumber++;
                k -= skipCount;
            } else {
                currentNumber *= 10;
                k--;
            }
        }
        return currentNumber;
    }
    
    private long skipCount(long current, long next, int n) {
        long skipCount = 0;
        while (current <= n) {
            skipCount += next - current;
            current *= 10;
            next *= 10;
            next = Math.min(next, (long) n + 1);
        }
        return skipCount;
    }
}
