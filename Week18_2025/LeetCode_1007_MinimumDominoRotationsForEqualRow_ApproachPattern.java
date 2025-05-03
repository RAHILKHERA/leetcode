package Week18_2025;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * LeetCode Problem: 1007 Minimum domino rotations for equal row.  
 * Problem Link: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/?envType=daily-question&envId=2025-05-03
 *
 * Input : 
 *  - Integer array tops, value on the top face of the domino.
 *  - Integer array bottoms, value on the bottom face of the domino. 
 * 
 * Definition : Rotation of Domino => Swap top and bottom value of the domino. 
 * 
 * Constraints:
 * n == tops.length
 * 2 <= tops.length <= 2 * 10^4
 * bottoms.length == tops.length
 * 1 <= tops[i], bottoms[i] <= 6
 * 
 * Task:
 * Find minimum number of operations to make all the face values in top or bottom row same. 
 *
 * Observations:
 * #1. Only way to change the value on the face is by swapping it with value on other face. 
 *  => Out of the full range of face values only two values needs to be checked. 
 *  => Two values would be the values on the top and bottom face of the first domino. 
 *  => Check if any row can be equalled to tops[0], if it fails check for the bottoms[0].
 * #2. Assuming that check is being perfomed for target,
 *  => Keep different counts where top and bottom doesn't match the target values. This will be the number of rotations required. 
 *  => If for any domino `idx`, target != tops[idx] && target != bottoms[idx], neither rows can be converted as required value is not needed. 
 *  => Once all the dominos are covered, return minimum number of rotations required. 
 *
 * Approach:
 * 1. Check if either of the row can be converted to tops[0], if not check with bottoms[0]. If this fails return -1. 
 * 2. Check the flip/rotations :
 *  => Keep two counters, to monitor number of rotations/flip required to convert each row. Minimum of them will be the answer. 
 *  => If any domino is found such that values on both the face does not match target value, return -1, as neither of the rows can be converted and no need to check further. 
 *  => Else, increase the counter for the row where mismatch occurs. Continue till all the dominos are processed. 
 * 3. Return minimum rotations/flips required to convert the row. 
 *    
 * Time Complexity: O(n), n = no. of dominos.
 * Space Complexity: O(1), no extra space proptional to the input size is used. 
 *  
 * Note : This approach is faster and scalable compare to another approach. 
 * => This approach does not depends on the range of the face values.
 * => If solution is not possible it is terminted earlier. 
 * 
 * Other Approaches : 
 * LeetCode_1007_MinimumDominoRotationsForEqualRow_ApproachCount.java
 */

public class LeetCode_1007_MinimumDominoRotationsForEqualRow_ApproachPattern {

    @Test
    public void test1() {
        assertEquals(2, minDominoRotations(new int[] {2,1,2,4,2,2}, new int [] {5,2,6,2,3,2}));
    }

    @Test
    public void test2() {
        assertEquals(-1, minDominoRotations(new int[] {3,5,1,2,3}, new int [] {3,6,3,3,4}));
    }

    
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int flips = minFlipsToMakeAllTarget(tops, bottoms, tops[0]);
        if (flips == -1) {
            return minFlipsToMakeAllTarget(tops, bottoms, bottoms[0]);
        }
        return flips; 
    }

    private int minFlipsToMakeAllTarget(int[] tops, int [] bottoms, int target) {
        int flipTop = 0;
        int flipBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                flipTop++;
            } else if (bottoms[i] != target) {
                flipBottom++;
            }
        }
        return Math.min(flipTop, flipBottom);
    }
}
