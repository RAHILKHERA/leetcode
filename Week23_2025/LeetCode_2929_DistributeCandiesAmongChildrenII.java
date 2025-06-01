package Week23_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 2929 Distribute Candies Among Children 2.
 * Problem Link: https://leetcode.com/problems/distribute-candies-among-children-ii/?envType=daily-question&envId=2025-06-01
 *
 * Input:
 * - Positive Integer n
 * - Positive Integer limit
 *
 * Constraints:
 * 1 <= n <= 10^6
 * 1 <= limit <= 10^6
 * 
 * Definition : 
 * -> n : There are n candies to be distributed. 
 * -> limit : No child can get more than limit candies. 
 *
 * Task: Number of ways to distribute the `n` candies among three children without any child receiving more than `limit` candies.
 *
 * Observations: 
 * #1. If first child gets x1 candies, second child gets x2 candies and third child get x3 candies,
 *  => x1 + x2 + x3 = n. 
 *  => x1, x2, x3 belongs to range [0, limit].
 * #2. There are n identical candies, and this requires to be distributed in k = 3 children. 
 *  => To distribute between k = 3 children, we need to insert k - 1 = 2 partitions in n chocolates. 
 *  => There are total n + k - 1 options and need to select k - 1 partitions. 
 *  => This can be solved using  C(n + k - 1, k - 1). 
 *  => This approach is known as `stars and bars`, 
 *  => n = number of stars (items), k = number of bins (children), k - 1 = number of bars (dividers)
 * #3 C(n,r) = n!/(r! (n - r)!)
 *  => C(n + k - 1, k - 1) = (n + k - 1)! /((k-1)! ((n + k - 1) - (k -1))!) 
 *  => C(n + 3 - 1, 3 -1)  = C(n + 2, 2) [ There are 3 children => k = 3].
 *  => C(n + 2, 2) = (n + 2)! / 2! ((n+2) - 2)! 
 *  => C(n + 2, 2) = (n + 2)! / 2*n! [2! = 2].
 *  => C(n + 2, 2) = (n + 2)(n + 1)n!/2*n!
 *  => C(n + 2, 2) = (n + 2)(n + 1)/2. -------------------------------------------------- Equation (1) 
 *  => C(x, 2) = (x)(x - 1)/2  [Generic Equation.]
 * #4. Without any constraints equation 1 will be the final answer, but in this case there is constraint in terms of limit.
 *  => a) Remove the way, at least one child has received more than limit candies i.e. limit + 1. 
 *      -> Equation (1) will be converted to C(n - (limit + 1) + 2, 2). There are 3 choices for each child to receive more than limit candies. 
 *      -> atLeastOneChildHasMoreThanLimit = 3 * C(n - (limit + 1) + 2, 2) ----------------- Equation (2)
 *  => b) 4.a will remove some distributions multiple times, corresponding to two or more children receiving more than limit candies.
 *      -> Add distributions with at least two children receiving more than limit candies. 
 *      -> Equation (1) will be converted to C(n - 2*(limit + 1) + 2, 2). 
 *      -> Selecting 2 children from available 3 children, can be done in C(3,2) = 3!/2!(3-2)! = 3!/2! = 3 ways.
 *      -> atLeastTwoChildrenHasMoreThanLimit = 3 * C(n - 2*(limit + 1) + 2, 2) ------------ Equation (3)
 *  => c) 4.b will add extra distributions corresponding to the case where all the three children receive more than limit candies.
 *      -> Remove distribution where all the children receive more than limit candies.
 *      -> Equation (1) will be converted to C(n - 3*(limit + 1) + 2, 2) ------------------- Equation (4)
 * => This is known as the inclusion-exclusion principle.
 *   
 * Approach:
 * 1. Implement Generic Equation combination(x), as second argument is same for all i.e. r = 2. The function will have only one argument. 
 *    => If x < 0, return 0. Combination cannot be applied for negative numbers. 
 *    => Compute and return x * (x - 1)/2. 
 * 2. Calculate equation(1), equation(2), equation(3) and equation(4) using combination(x).
 *    => All equations follow same pattern, as all the equations as + 2 factor and each combination has value r = 2. 
 *    => which will be negated as in derivation of generic equation. 
 * 3. Compute Final Answer = Equation(1) - Equation(2) + Equation(3) - Equation(4).    
 *    
 *  
 * Time Complexity: O(1)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | Compute the equation                                  | O(1)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(1)                               |
 * 
 * 
 * Space Complexity: O(1)
 * |          Component                                    |   Time                             |
 * | ----------------------------------------------------- | ---------------------------------- |
 * | No extra space is utilized.                           | O(1)                               |
 * |-------------------------------------------------------|------------------------------------|
 * | Total Complexity                                      | O(1)                               |
 *
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2929_DistributeCandiesAmongChildrenII {

    @Test
    public void test1() {
        assertEquals(3, distributeCandies(5, 2));
    }

    @Test
    public void test2() {
        assertEquals(10, distributeCandies(3, 3));
    }

    public long distributeCandies(int n, int limit) {
        int k = 3; // number of children
        long totalOptionsWithoutConstraints = combination(n + k - 1);
        long atleastOneChildHasMorethanlimit = 3 * combination(n - (limit + 1) + k - 1);
        long atleastTwoChildrenHasMorethanlimit = 3 * combination(n - 2 * (limit + 1) + k - 1);
        long allThreeChildrenHasMorethanlimit = combination(n - 3 * (limit + 1) + k - 1);
        long totalWays = totalOptionsWithoutConstraints - atleastOneChildHasMorethanlimit
                + atleastTwoChildrenHasMorethanlimit - allThreeChildrenHasMorethanlimit;
        return totalWays;
    }

    /**
     * C(n,r) = n!/ r!(n -r)!
     * C(n+2, r) = (n+2)! / r! (n + 2 -r)!
     * C(n+2, 2) = (n+2)! / 2! (n + 2 - 2)! = (n+2)! / 2*n! = (n+2)(n+1)n!/2*n! =
     * (n+2)(n+1)/2
     * C(x,2) = (x) * (x - 1)/ 2/
     */
    public long combination(int x) {
        if (x < 0)
            return 0;
        return ((long) x * (x - 1)) / 2;
    }
}
