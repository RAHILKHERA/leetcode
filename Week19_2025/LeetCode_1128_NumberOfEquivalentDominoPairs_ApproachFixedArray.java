package Week19_2025;

/**
 * 
 * LeetCode Problem: 1128 Number of equivalent domino pairs. 
 * Problem Link: https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/?envType=daily-question&envId=2025-05-04
 *
 * 
 * Input : 
 *  - Integer 2D array dominos 
 * 
 * Definition :  dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c).
 * 
 * Constraints:
 * 1 <= dominoes.length <= 4 * 10^4
 * dominoes[i].length == 2
 * 1 <= dominoes[i][j] <= 9
 * 
 * Task:
 * Count the number of equivalent pairs of dominoes. 
 *
 * Observations:
 * #1. At index idx, with dominoes[idx] = [a,b], if it can be answered how many dominoes in past either of value a,b or b,a
 *     then, the number of equivalent pairs that can be created will be count of such pairs seen in past.
 * #2. This points to the classic map counting problem, where a single key will represent domino with value a,b or b,a. 
 * #3. At every dominoes, calculate the key, and increase the total count by total dominoes already found with same key. 
 * #4. Increase the count of total dominoes with this key by 1. As now there is one more candidate for pairing. 
 * #5. As the dominoes face values is from 1 to 9 and there are two faces of the domino. 
 *     => This can be used to generate a 2 digit numeric key, by multiplying higher face value with 10 and adding lower value.
 *     => Reverse of the above will still work, i.e. the multiplying lowere face value with 10 and adding higher value. 
 *     => As the range of face is from 1 to 9. The biggest key that can be genrated is 99. 
 *     => So instead of using hashmap, an array of size 100 can be used, where it's index is the key and the value is number 
 *        of pairs found with the same key. 
 * 
 * Approach:
 * 1. Create an array of size 100 where index is the key and value is the count of previous pair found in past. 
 * 2. For each domino, generate the key(k). 
 *    => Find the higher value(h) and lower value(l) of the domino's face.  
 *    => k = h * 10 + l; (even k = l * 10 + h is fine, as the domino and it's rotation both will generate the same key). 
 * 3. Check the map, if there was a previous domino with the same key. 
 *    => Number of new pairs with the current dominos is equal to previous number of dominos present with the same key. 
 *    => For e.g a, b, c were the previous dominos with equivalent to current domino d. 
 *       So with d, 3 new pairs (a,d), (b,d) and (c,d) will be created. 
 * 4. Increment the count of the current key by 1, as current domino will be available for the upcoming domino to pair up. 
 * 
 * Time Complexity: O(n) 
 *      - Traverse all the dominos once - O(n)
 *      - Map operations - O(1)
 *      - Final Complexity -> O(n)
 * Space Complexity: O(1)
 *      - Map in form of array of size 100 - O(100) => O(1)
 * 
 * Note : This approach is fastest of all, as for the map array is used. 
 *        The space usage remains constant but the scalablity is capped by the range of the domino's face.  
 * 
 * Other Approaches : 
 * LeetCode_1128_NumberOfEquivalentDominoPairs_ApproachIntegerMap.java
 * LeetCode_1128_NumberOfEquivalentDominoPairs_ApproachStringMap.java
 * 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1128_NumberOfEquivalentDominoPairs_ApproachFixedArray {

    @Test
    public void test1() {
        assertEquals(1, numEquivDominoPairs(new int[][] { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } }));
    }

    @Test
    public void test2() {
        assertEquals(3, numEquivDominoPairs(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } }));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] map = new int[100];
        for (int[] domino : dominoes) {
            int key = domino[0] > domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            count += map[key];
            map[key]++;
        }
        return count;
    }

}
