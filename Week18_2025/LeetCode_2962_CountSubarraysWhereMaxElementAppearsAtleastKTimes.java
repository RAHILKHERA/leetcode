package Week18_2025;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * LeetCode Problem: 2962 Count subarrays where max elements appears at least k times.  
 * Problem Link:
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29
 *
 * Input : 
 *  - Integer array nums. 
 *  - Integer k. 
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= k <= 10^5
 * 
 * Task: Count number of subarrays where max element of the array appears at least k times. 
 *
 * Observations:
 * #1. Find out max element, so the frequency of it can be matched in each subarray. 
 * #2. For a subarray ending at index idx, if max elements occurs exactly k times, then all the subarrays till the last position remains valid. 
 *     => Increase count by n - idx, where n is number elements in the array. 
 * #3. From the starting of the subarray, the length can be reduced and if still max element appears k times, then as per #2 increase count by n - idx. 
 * #4. This points to the classic sliding window protocol with dynamic window. 
 *     
 * Approach:
 * 1. Find maximum element by traversing the array. 
 * 2. Maintain two pointers, left for start of the subarray and right for the end of the subarray. 
 * 3. Maintain count of the max element (maxFreq) in current window/subarray. 
 * 4. When subarray has exactly k number of max elements, then all subarrays from right to last position are valid. 
 *    a) Increment count by n - right. 
 *    b) Shrink the window/subarray using left pointer, if still there are exactly k number of max elements, increament count as of 4a.
 * 
 * Time Complexity: O(n) 
 *     - Finding maximum of the array O(n). 
 *     - Sliding Window Protocol, every element is visited twice O(n). 
 *     - n = length of the array nums. 
 *
 * Space Complexity: O(1)
 *      - No extra space proportional to input is used. 
 */



public class LeetCode_2962_CountSubarraysWhereMaxElementAppearsAtleastKTimes {
    
    @Test
    public void test1() {
        assertEquals(6, countSubarrays(new int [] {1,3,2,3,3}, 2));
    }

    @Test
    public void test2() {
        assertEquals(0, countSubarrays(new int [] {1,4,2,1}, 3));
    }

    public long countSubarrays(int[] nums, int k) {
        
        int max = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }

        long count = 0;
        int n = nums.length;
        int maxFreq = 0;       
        for (int right = 0, left = 0; right < n; right++) {

            if (nums[right] == max) {
                maxFreq++;
            }

            while(maxFreq == k && left <= right) {
                count += n - right;
                if(nums[left] == max) {
                    maxFreq--;
                }
                left++;
            }
        }

        return count;
    }
}
