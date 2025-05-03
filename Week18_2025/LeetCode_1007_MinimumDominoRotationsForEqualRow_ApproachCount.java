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
 * #1. To make all the values in either of the rows equal, a number should appear atleast n number of times. 
 *  => If there are no such number, then it is not possible to make row value equal. 
 *  => At most only one number with frequency greater than equal to n will exists. 
 * #2. Assuming, x such that frequency(x) >= n,
 *     => top(x) = frequency of x in top row.
 *     => bottom(x) = frequency of x in bottom row. 
 *     => x' = n - top(x) = number of faces not having x in top row. =>  This many rotations will be required to make top row symmetrical. 
 *     => y' = n - bottom(x) = number of faces not having x in bottom row. => This many rotations will be required to make bottom row symmetrical.
 *     => answer = min(x', y').  
 * #3. frequency(x),
 *     => frequency(x) is not just equal to the summation of its occurance of x in tops and bottoms. 
 *     => When x appears on both the face of the single domino, that domino should not be considered for rotation. 
 *     => Here, number of dominos have both faces x (same(x)) should be reduced from the summation of the frequency in top and bottom row. 
 *     => frequency(x) = top(x) + bottom(x) - same(x).  
 * #4. Domino's face values range from 1 to 6.
 * 
 * Approach:
 * 1. Create a 7 x 3 arrray to keep the frequency of each element (scores). 
 *    => 7 rows to repersent each face value from 1 to 6. 
 *    => 3 columns to represent frequency of number in top row, bottom row and in case both the faces have same values. 
 *    => scores[idx][0] = frequency of idx in top row. 
 *    => scores[idx][1] = frequency of idx in bottom row. 
 *    => scores[idx][2] = frequency of the dominos have both face values = idx. 
 * 2. Traverse both the arrays together, and fill the scores array. 
 * 3. Check which number satisfies scores[idx][0] + scores[idx][1] - scores[idx][2] >= n, 
 *    => answer is min(n- scores[idx][0], n- scores[idx][1])
 * 
 * Time Complexity: O(n), n = no. of dominos.
 *  - O(n) -> Traverse both the arrays together, each of length n.  
 *  - O(6) -> Check condition and calculate the rotations. 
 *  - Total Complexity -> O(n+6) => O(n). 
 * 
 * Space Complexity: O(1), 
 *  - O(21) -> Array of size 7 * 3 is used. But it is not propotional to input size. 
 *  => O(21) = O(1). 
 * 
 * Note : This approach is not scalable if the face value range is changed. 
 * 
 * Other Approaches : 
 * LeetCode_1007_MinimumDominoRotationsForEqualRow_ApproachCount.java
 */

public class LeetCode_1007_MinimumDominoRotationsForEqualRow_ApproachCount {

    @Test
    public void test1() {
        assertEquals(2, minDominoRotations(new int[] {2,1,2,4,2,2}, new int [] {5,2,6,2,3,2}));
    }

    @Test
    public void test2() {
        assertEquals(-1, minDominoRotations(new int[] {3,5,1,2,3}, new int [] {3,6,3,3,4}));
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int [][] scores = new int [7][3];
        for (int i = 0; i < n; i++) {
            scores[tops[i]][0]++;
            scores[bottoms[i]][1]++;
            if (tops[i] == bottoms[i]) {
                scores[tops[i]][2]++;
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (scores[i][0] + scores[i][1] - scores[i][2]>= n) {
                return Math.min(n - scores[i][0], n - scores[i][1]);
            }
        }

        return -1;
    }
}
