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
 * #5. As the dominoes face values is low and positive, bit manipulation can be used. 
 *     => Right shift 1 by both face values and perform OR operation between both. 
 *     => This will create a key where the face values bit will be set. 
 *     => For both, domino and its rotation, it will generate the same key.  
 * 
 * Approach:
 * 1. Create a hashmap of type integer vs integer, for key vs count.
 * 2. For each domino, generate the key. 
 *    => Right shift 1 by both the domino's faces and perform OR operation.  
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
 * Space Complexity: O(n)
 *      - Map is used for key vs count - O(n) 
 * 
 * Note : This approach is not fully scalable. The type of key is used interger that is 32 bit, so the range of the dominos's  face 
 * value can only be 0 to 31.   
 *  
 * Other Approaches : 
 * LeetCode_1128_NumberOfEquivalentDominoPairs_ApproachFixedArray.java
 * LeetCode_1128_NumberOfEquivalentDominoPairs_ApproachStringMap.java
 */

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_1128_NumberOfEquivalentDominoPairs_ApproachIntegerMap {

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
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            int key = (1 << domino[0]) | (1 << domino[1]);
            int frequency = map.getOrDefault(key, 0);
            count += frequency;
            map.put(key, frequency + 1);
        }
        return count;
    }

}
