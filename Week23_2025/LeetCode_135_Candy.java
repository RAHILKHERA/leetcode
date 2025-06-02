package Week23_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 135 Candy
 * Problem Link: https://leetcode.com/problems/candy/?envType=daily-question&envId=2025-06-02
 *
 * Input:
 * - Non-negative integer array: ratings. 
 * 
 * Constraints:
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 * 
 * 
 * Definition: 
 * -> ratings: There are n children and each child has been assigned a rating. 
 * -> Each child must have at least one candy. 
 * -> Children with higher rating get more candies than their neighbors. 
 *
 * Task: Compute the minimum number of candies required to distribute the candies to the children. 
 *
 * Observations: 
 * #1. Except the first and last child, each child has two neighboring children: one on the left and one on the right. 
 *     => Need to check ratings with both the neighbors to decide the number of candies a child will receive. 
 *     => Handling both the left and right neighbor independently will be helpful. 
 * #2. If the current child's rating is more than the rating of the child on its left,
 *  => Then assign one candy more than the candies with the left child.
 * #3. If the current child's rating is more than the rating of the child on its right, 
 *  => Here it is necessary to check if the candies already assigned to the child are less than or equal to the child on the right. (check (1))
 *  => The reason for the check is that it could be possible that while checking for the left neighbor, this child was assigned higher candies.
 *  => If check 1 was passed, then only assign one candy more than the candies with the right child. Check the test case #3.    
 * 
 *   
 * Approach:
 * 1. Keep an array `candies` of size `n` to keep track of the candies assigned. 
 *    => Initialize `candies` with value 1, as all the children receive at least 1 candy. 
 * 2. For each `child` from left to right,
 *    => If ratings[child] > ratings[child - 1], candies[child] = candies[child - 1] + 1.
 *    => No need to check the already assigned candies as at this stage it will be in increasing sequence.
 *    => That is, either the child has the same candies or less. 
 * 3. For each `child` from right to left,
 *  => If ratings[child] > ratings[child + 1] and candies[child] <= candies[child + 1]
 *  => candies[child] = candies[child + 1] + 1. 
 *  => Additionally, during this traversal, keep track of the total number of candies `totalCandies` used. 
 * 4. +1 in the above equation to satisfy the higher candies with higher rating condition and to keep the total candies minimum. 
 *    
 * Time Complexity: O(n)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Initialize candies                                    | O(n)                               |
 * | Traverse left to right (Check left neighbors)         | O(n)                               |
 * | Traverse right to left and candies summation          | O(n)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n + n + n) = O(3n) => O(n)       |
 * 
 * 
 * Space Complexity: O(n)
 * |          Component                                    |   Space                            |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | number of candies assigned to each child.             | O(n)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(n)                               |
 *
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_135_Candy {

    @Test
    public void test1() {
        assertEquals(5, candy(new int[] { 1, 0, 2 }));
    }

    @Test
    public void test2() {
        assertEquals(4, candy(new int[] { 1, 2, 2 }));
    }

    @Test
    public void test3() {
        assertEquals(11, candy(new int[] { 1,3,4,5,2 }));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int child = 1; child < n; child++) {
            if (ratings[child] > ratings[child - 1]) {
                candies[child] = candies[child - 1] + 1;
            }
        }

        int totalCandies = candies[n - 1];

        for (int child = n - 2; child >= 0; child--) {
            if ((ratings[child] > ratings[child + 1]) && (candies[child] <= candies[child + 1])) {
                candies[child] = candies[child + 1] + 1;
            }
            totalCandies += candies[child];
        }

        return totalCandies;
    }
}
