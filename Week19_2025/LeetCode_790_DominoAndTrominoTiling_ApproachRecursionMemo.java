package Week19_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 790 Domino and Tromino Tiling. 
 * Problem Link: https://leetcode.com/problems/domino-and-tromino-tiling/description/
 *
 * Input : 
 *  - Integer n
 * 
 * Definition :
 * -> Dominos : [#][#] or [#]
 *                        [#]
 * -> Trominos : [#][#] or [#][#] or [#]    or    [#]
 *                  [#]    [#]       [#][#]    [#][#]
 *   
 * Constraints:
 * 1 <= n <= 1000
 * 
 * Task:
 * -> For given integer n, find the number of unique ways a 2 * n tile can be created using a dominos and trominos. 
 * -> In tiling, every square must be covered by a tile.
 * -> Duplicate ways are not allowed. For e.g. for n = 3, required tile will be 2 * 3 i.e. 2 rows and 3 columns. 
 *    If 3 vertical dominos(a,b,c) are placed side by side, it will be one of the way to create tile. 
 *    But b,c,a will be counted as duplicate domino.  
 *
 * Observations:
 * #1. There are two options to create the tile, either use domino or tromino. Also there are multiple ways to achieve the goal i.e. to create the tile. 
 *     => This points to dynamic programming type of problem.
 * #2. There is no direct observation here, needs to work out for initial values of n starting from n to observe the pattern. 
 * #3. For n = 1, [#]
 *                [#]
 * 
 * #4. For n = 2, [#][#] and [=][=]  ([=][=] to represent horizontal domino). 
 *                [#][#]     [=][=]
 *
 * #5. For n = 3, [#][#][#]  [#][=][=]  [=][=][#]  [%][%][&]  [%][&][&]
 *                [#][#][#], [#][=][=], [=][=][#], [%][&][&], [%][%][&]
 *
 * #6. For n = 4, [#][#][#][#]  [=][=][=][=]  [#][#][=][=]  [=][=][#][#] 
 *                [#][#][#][#], [=][=][=][=], [#][#][=][=], [=][=][#][#],
 * 
 *                [#][=][=][#]  [%][%][&][#]  [#][%][%][#]  [#][%][&][&]
 *                [#][=][=][#], [%][&][&][#], [#][%][#][#], [#][%][%][&],
 * 
 *                [%][&][&][#]  [%][%][&][&],   [%][=][=][&]
 *                [%][%][&][#], [%][=][=][&],   [%][%][&][&]
 * 
 * #7. Each tile is of size 2*n, if it is partitioned into two parts at p columns,
 *     => Then one part will have p columns and another part will have n - p columns. 
 *     => The tile will be divide into two smaller tiles, one of 2 * p and one of 2 * (n-p).
 *     => If there are x ways to create 2*p tile and y ways to create 2 * (n - p) tile, 
 *     => Then total ways to create 2*n, will be x * y. 
 *     => f(N) = Number of ways to create the 2*N tile.  
 * 
 * #8. Case 1, If p = 1, i.e. the tile is divided as N-1 columns and 1 column. 
 *     => f(N-1) * f(1)
 *     = f(N-1) * 1  [As observed in the example, for n = 1, there is only one way. ]
 *     = f(N-1) 
 * 
 * #9. Case 2, if p = 2, Tile divided in N-2 colums and 2 columns. 
 *   => f(N-2) * f(2)
 *   => To understand this, take example for f(4) => f(2) * f(2)
 *        Consider tile of f(2) [#][#], This tile can be combine with itself to create  [#][#][#][#]
 *                              [#][#]                                                  [#][#][#][#]
 *        But this tile, was already created in f(4) => f(3) * f(1) in following manner : 
 *                  f(N-1) * f(1) => f(3) * f(1)
 *                  [#][#][#]  [#]
 *                  [#][#][#]  [#].
 *   => The duplicate tile is created due to vertical domino in f(2), hence that will be neglected as in other combination that will be covered. 
 *   => f(2) = 1. 
 *   => f(N-2) * f(2) = f(N-2)
 * 
 * #10. Case 3, if p = 3, Tile divided in N - 3 columns and 3 columns. 
 *  => f(N-3) * f(3)
 *  => f(3) = 5, But out of this 5 only two tiles, which were created using tromino are unique, other three which were created only by dominos can be created by combination of f(2) and f(1).
 *  => Hence unique ways to create tile from f(3) = 2.
 *  => f(N-3) * f(3) = f(N-3) * 2. 
 *  => Hence no need to count tiles created only by dominos, as all the combination of the dominos are counted in other combinations.  
 * 
 * #11. Case 4, if p = 4, Tile  divided in N - 4 columns and 4 columns. 
 *  => On observing the f(4), it is clear that only two unique new tiles have been generated using trominos (last two) while all others can be dervide from previous values. 
 *  => f(N-4) * 2. 
 * 
 * #12 From above observations it can be concluded that 
 *      
 *    f(N) = f(N-1) + f(N-2) + 2*f(N-3) + 2*f(N-4) +......+ 2*f(0) ............. equation 1
 *    f(N-1) = f(N-2) + f(N-3) + 2* f(N-4) + 2*f(N-5) + ...... + 2*f(0).......... equation 2
 *    => Subtracting equation 2 from equation 1
 *    => f(N) - f(N-1) = f(N-1) + f(N-3) [All other terms will be cancelled out].
 *    => f(N) = 2 * f(N-1) + f(N-3).   
 * 
 *  
 * Approach:
 * 1. To solve the equation f(N) = 2*f(N-1) + f(N-3), recursion with memoization can be used i.e. top down approach of dynamic progrmmic. 
 * 2. Only one variable defines the state. Hence it is a 1-D dp problem. 
 * 3. Create and initialize an array `memo` to store the intermediate results. The state which is not previously calculated is represented by -1. 
 * 4. f(N) is implemented as solve(n), with 3 base case n = 1, 2 and 3. The reason behinde including n = 3, is that this is the first case where tile are created using trominos. 
 * 5. At each stage, perform mod operation with 10^9 + 7 as the results could be large values. 
 * 
 * Time Complexity: O(n) 
 *      - Intialize dp state array `memo` by -1 -> O(n)
 *      - The recursion covers all the states from n to 1.
 *      - Final Complexity : O(2*n + 1) = O(n)
 *      
 * Space Complexity: O(n)
 *      - Due to recursion which creates tree of height n, the space used will be O(n)
 *      - Additionally, using 1-D array of size n + 1 to store the intermediate results.
 *      - Final Complexity : O(n + n + 1) = O(2*n + 1) = O(n).
 
 * Other Approaches : 
 * LeetCode_790_DominoAndTrominoTiling_ApproachBottomUp.java
 * 
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_790_DominoAndTrominoTiling_ApproachRecursionMemo {
    private static final int MOD = 1_000_000_000 + 7;
    private int[] memo;

    @Test
    public void test1() {
        assertEquals(5, numTilings(3));
    }

    @Test
    public void test2() {
        assertEquals(1, numTilings(1));
    }

    @Test
    public void test3() {
        assertEquals(11, numTilings(4));
    }

    public int numTilings(int n) {

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(n);
    }

    private int solve(int n) {

        if (n < 3) {
            return n;
        }

        if (n == 3) {
            return 5;
        }

        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = ((2 * solve(n - 1) % MOD) + solve(n - 3) % MOD) % MOD;
        return memo[n];
    }
}
