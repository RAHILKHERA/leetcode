package Week21_2025;

import static org.junit.Assert.assertEquals;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 1931 Painting a grid with three different colors. 
 * Problem Link: https://leetcode.com/problems/painting-a-grid-with-three-different-colors/description/?envType=daily-question&envId=2025-05-18
 *
 * Input:
 * - integer m, representing rows. 
 * - integer n  representing columns. 
 * 
 * Constraints:
 * 1 <= m <= 5
 * 1 <= n <= 1000
 *
 * Definition: 
 * - A cell can be painted in either red, blue or green. The only condition is it's color should not match it's adjacent cells. 
 *
 * Task: Find the number of ways to color the grid with no two adjacent cells having the same color. 
 *
 * Observations:
 * 1) maximum 3 options for each cells, as we have options it points to some type of dynamic programming. 
 * 2) To find the combinations for the 0th row, it is easy as the previous row is not available. All the valid combinations of the color are available for the 0th row. 
 * 3) Valid combinations are those whose no two cells are same. 
 * 4) Each row combination will of maximum length 1000. Hence in worst case, all the valid states will be of 1000 length. Instead of row wise we can process it column wise, as the number of rows at max will be 5. 
 *    => In this case single valid state will be at max of length of 5. 
 * 5) If constraints are not applied, 3^m possible states are there for a column with m rows and 3 colors. 
 * 6) To generate valid states, convert the state number into base-3 representation of length m. If any two consecutive digits (representing adjacent cells) are equal, the state is invalid.
 * 7) Valid states just represents that in a single column, there are no same colors in adjacent cells. i.e. vertically adjacent cells don't have the same colors. 
 * 8). To count the combination as valid, even the horizontal adjacent cells should not have the same colors. For example if column c -1 has valid state s and to check if valid state t can  be used for column c, we will equate cell of each column, if match is found, then t cannot be used. But if no match is found, s can be used as predecessor of t. 
 * 9) Only previous column state is required to know if a valid state can be used for current column. So only two 1D arrays of size of total states is sufficient. 
 * 10) For the first column (0th column), all the valid states are available, hence if it is a valid state, count it as 1 else 0. 
 * 11) traverse from column 1 to column n -1, loop through all the states, if state is valid, and there are predecessor state, we have a combination to using that state, this will be incremented for each column. 
 * 12) Finally at the end, the dp will have combinations possible with each valid column states.  The summation of this dp array will provide all the combinations.  
 *
 * Approach:
 * 1. Total possible states without conditions =  3^m. 
 * 2. Generate valid states using k-encoding. Here k = 3. 
 * 3. To map a state to color coding of size m, perform state % 3, this will either provide 0, 1, 2 each represnting one color. 
 *    => If at any point the current remainder i.e. color matches previous one, it is not a valid state. 
 *    => Maintain a boolean array of size total states where true represents a valid state. 
 *    => To move to next row in the column perform state /= 3. 
 * 4. The valid states only represnts color combination which does not have same color on vertical adjacent cells. 
 *    => Now to further narrow down, i.e. to make sure that horizontal adjacent cells does not contain, same color. 
 *    => Each state represents a column, with m rows. So each cell of both columns need to be matched.
 *    => Same technique can be used (state % 3) to match the cell. 
 *    => For each valid state (t), another valid state (s) can be it's predecessor. If no cells in a single row have same color. 
 *    => If s is predecessor of t, s was selected valid state for a column (c-1) than t can be chosen for column (c). 
 *    => Create a list of predecessor for each valid state. 
 * 5. The number of combinations for current column just depends on previous column. So no need of full 2D grid to store the states. 
 *    => 2 1-D arrays of size total states is sufficient. One for current state and one for previous state. 
 *    => During next iteration, current state will become previous state and calculate the new current state. 
 * 6. Iterate, through each column,
 *    => Iterate through all the states. If valid.
 *    => Fetch all the predecessor i.e. compatible states s. 
 *    => Add dpPrev[s] to dpCurrent[t],
 * 7. Finally sum the combinations starting with each valid state. 
 *    => if each valid state used in the first column, the number of combinations available. 
 *    => This can be done by performing summation over dpPrevious.     
 *    
 *
 * Time Complexity: O(k^m × m + V² × (m + n))
 * m = number of rows (≤ 5)
 * n = number of columns (≤ 1000)
 * k = number of colors (3)
 * V = number of valid states (each state represents a valid color assignment to a column of m rows without adjacent same-color cells)
 * Valid State Generation:
 *  - Total possible states per column = k^m
 *  - To check each state for vertical validity = O(k^m * m)
 * Predecessor Computation : Build a map of which state transitions are allowed between adjacent columns (horizontal compatibility)
 *  -Traverse all the vertical states and each state is of length m. O(V^2 * m)
 * DP Traversal :
 *  - For each column for 1 to n-1.
 *  - Iterate over all compatible previous state s, Time per column = O(V * avgCompat)
 *  - In Worst case avgCompat = V. 
 *  - Total DP Time = O(n * V^2)
 * Total Complexity = O(k^m × m + V² × m + n × V²) => O(k^m × m + V² × (m + n))

 *
 * Space Complexity: O(V^2)
 * | Component         | Space     |
 * | ----------------- | --------- |
 * | Valid states list | O(V)      |
 * | Compatibility map | O(V²)     |
 * | DP arrays (2 × V) | O(V)      |
 * | **Total**         | **O(V²)** |
 */

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_1931_PaintingAGridWithThreeDifferentColors {

    @Test
    public void test1() {
        assertEquals(3, colorTheGrid(1, 1));
    }

    @Test
    public void test2() {
        assertEquals(6, colorTheGrid(1, 2));
    }
    
    @Test
    public void test3() {
        assertEquals(580986, colorTheGrid(5, 5));
    }
    
    private static final int MOD = 1_000_000_000 + 7;
    private int m;
    private int totalStates;
    private boolean validStates[];
    private List<Integer>[] predecessors;

    @SuppressWarnings("unchecked")
    private void init(int m) {
        this.m = m;
        totalStates = (int) Math.pow(3, m);
        validStates = new boolean[totalStates];
        predecessors = new List[totalStates];
        for (int state = 0; state < totalStates; state++) {
            predecessors[state] = new ArrayList<>();
        }
    }

    public int colorTheGrid(int m, int n) {

        init(m);
        fillValidStates();
        findPredecessors();

        int[] dpPrevious = new int[totalStates];
        // col = 0, all the valid states or combinations can be selected for the 0th
        // column.
        for (int i = 0; i < totalStates; i++) {
            dpPrevious[i] = validStates[i] ? 1 : 0;
        }

        // Use predecessor, to compute the combinations for col[i] by taking col[i-1]
        // into consideration.
        for (int col = 1; col < n; col++) {
            int[] dpCurrent = new int[totalStates];
            for (int t = 0; t < totalStates; t++) {
                if (validStates[t]) {
                    int ways = 0;
                    for (int s : predecessors[t]) {
                        ways = (ways + dpPrevious[s]) % MOD;
                    }
                    dpCurrent[t] = ways;
                }
            }
            dpPrevious = dpCurrent;
        }

        int combinations = 0;

        for (int s = 0; s < totalStates; s++) {
            combinations = (combinations + dpPrevious[s]) % MOD;
        }

        return combinations;
    }

    private void findPredecessors() {
        for (int s = 0; s < totalStates; s++) {
            if (validStates[s]) {
                for (int t = 0; t < totalStates; t++) {
                    if (validStates[t] && isCompatible(s, t)) {
                        predecessors[t].add(s);
                    }
                }
            }
        }
    }

    private boolean isCompatible(int s, int t) {

        for (int i = 0; i < m; i++) {
            if (s % 3 == t % 3) {
                return false;
            }
            s /= 3;
            t /= 3;
        }
        return true;
    }

    private void fillValidStates() {
        for (int i = 0; i < totalStates; i++) {
            validStates[i] = generateValidState(i);
        }
    }

    private boolean generateValidState(int state) {
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            int color = state % 3;

            if (i > 0 && color == rows[i - 1]) {
                return false;
            }
            rows[i] = color;
            state /= 3;
        }
        return true;
    }
}
