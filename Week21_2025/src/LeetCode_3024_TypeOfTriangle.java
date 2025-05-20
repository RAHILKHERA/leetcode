package Week21_2025;

/**
 * @RAHILKHERA
 * 
 * LeetCode Problem: 3024 Type of Triangle. 
 * Problem Link:
 * https://leetcode.com/problems/type-of-triangle/?envType=daily-question&envId=2025-05-19
 *
 * Input :
 * - Input integer array of size 3, representing the length of each side of the triangle.
 * 
 * Definition : 
 * - Triangle : A three sided polygon where sum of length of all pair of two sides of the triangle should be greater than remaining side. 
 * - Equilateral : Length of all the sides are equal. 
 * - Isosceles : Length of two sides of the triangle are equal. 
 * - Scalene : A valid triangle without, all distinct sides.  
 * 
 * Constraints:
 * nums.length == 3
 * 1 <= nums[i] <= 100
 * 
 * Task: Return type of the triangle for given values of the length of sides of the triangle. 
 *
 * Observations:
 * #1. First check for the valid triangle, else the case where two sides are equal but there summation less than third side will fail. 
 * #2. Don't just count the frequency of just first side, it will fail when 2nd and 3rd side of the triangle will match. 
 * #3. One way is to sort the array. 
 *     => If sum of the first two lengths is less than equal to largest length of the triangle then return None as it cannot form a triangle. 
 *     => else if first and last element are same, then it is an equilateral triangle. 
 *     => Else if either of the pairs are same, then it is an isosceles triangle. 
 *     => Else it is scalene. 
 * #4. Without sort, check all the conditions 
 *  => If sum of any pair of sides is less than equal to third side, it cannot form triangle. 
 *  => If all sides are equal, it is an equilateral traingle. 
 *  => If any of the two sides are equal, it is an isosceles triangle.
 *  => If all sides are distinct, it is a scalene triangle. 
 * 
 * Approach:
 * 1. Check if valid triangle can be created. 
 *    => nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0].
 *    => Invalid triplet, cannot be a triangle. 
 *    => Type = none.   
 * 2. Check if all sides are equal.
 *    => nums[0] == nums[1] && nums[1] == nums[2]
 *    => Type = equilateral  
 * 3. Check if any two sides are equal. 
 *    => nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]
 *    => Type = isosceles
 * 4. If none of the conditions are satisfied => triplet is a valid triangle with all sides with distinct lengths. 
 *    => Type = scalene.    
 * 
 * Time Complexity: O(1)
 *  - This check is done in constant time.  
 * Space Complexity: O(1)
 *  - No extra space is used. 
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_3024_TypeOfTriangle {

    @Test
    public void test1() {
        assertEquals(EQUILATERAL, triangleType(new int[] { 3, 3, 3 }));
    }

    @Test
    public void test2() {
        assertEquals(SCALENE, triangleType(new int[] { 3, 4, 5 }));
    }

    @Test
    public void test3() {
        assertEquals(NONE, triangleType(new int[] { 5, 3, 8 }));
    }

    @Test
    public void test4() {
        assertEquals(NONE, triangleType(new int[] { 8, 4, 4 }));
    }

    @Test
    public void test5() {
        assertEquals(ISOSCELES, triangleType(new int[] { 2, 7, 7 }));
    }

    @Test
    public void test6() {
        assertEquals(ISOSCELES, triangleType(new int[] { 9, 4, 9 }));
    }

    private static final String EQUILATERAL = "equilateral";
    private static final String ISOSCELES = "isosceles";
    private static final String SCALENE = "scalene";
    private static final String NONE = "none";

    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0])
            return NONE;
        if (nums[0] == nums[1] && nums[1] == nums[2])
            return EQUILATERAL;
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
            return ISOSCELES;
        return SCALENE;
    }
}
