package Week15_2025;

/**
 * LeetCode Problem: 3375 Minimum Operations to Make Array Values Equal To k
 * Problem Link: 
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09
 * 
 * Task: Minimum number of operations to make all the elements in the array equal to k. If not possible return -1.
 * Definition : An integer 'h' is called valid, if all the values in the array, strickly greater than 'h' are equal. 
 * Operation : Select a valid value 'h' for current values of array and replace all the greater values than h by h. 
 *  
 * Observation :
 * #1 In each operation, a smaller elements gets selected and replaces all the occurences of the larger elements.  
 * #2 If there is an element in array smaller than k, than it is impossible to make all the elements equal to k, because for that element
 * value needs to be increased but operation can only reduce the value. Return -1 in this case. 
 * #3 Element h is only valid if all the greater values are same. This leads to observation that processing needs to start with largest element. 
 * In each operation, replace the largest element with second largest value. 
 * #4 This points to sorting the array in non-increasing order. And check number of elements that don't match with their adjacent element. 
 * That will be the number of opeations, explicitly check if the last element is greater than k, than increase the required operations by 1. 
 * #5 From 4, It can be deduced that it is finding number of distinct elements larger than k. If smaller than k is found return -1. 
 * 
 * Approach:
 * #1 To maintain, distinct elements, set will be used. 
 * #2 If element is greater than k, add to set. 
 * #3 If element is already equal to k, ignore it.
 * #4 If element is smaller than k,  this array cannot be converted. Return -1 from here. 
 * 
 * Time Complexity: O(n) => All the elements are visited only once and it takes O(1) for element to be added to set. 
 * Space Complexity: O(n) => Using set to store the larger distinct elements. In worst case, all the elements of the array would be present in set.   
 * where n = input length
 */
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LeetCode_3375_MinimumOperationstoMakeArrayValuesEqualTok {

    @Test
    public void test1() {
        assertEquals(2, minOperations(new int[] { 5, 2, 5, 4, 5 }, 2));
    }

    @Test
    public void test2() {
        assertEquals(-1, minOperations(new int[] { 2, 1, 2 }, 2));
    }

    @Test
    public void test3() {
        assertEquals(4, minOperations(new int[] { 9, 7, 5, 3 }, 1));
    }

    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                set.add(num);
            }
        }
        return set.size();
    }
}
