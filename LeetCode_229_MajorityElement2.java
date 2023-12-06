import java.util.ArrayList;
import java.util.List;

public class LeetCode_229_MajorityElement2 {
    
}

class Solution_LeetCode_229_MajorityElement2 {
    
    public List<Integer> majorityElement(int[] nums) {

        /**
         * Intituation behind, with n elements if there are elements with frequencey equal to n/3 than that can be at most 3 elements. 
         * Here we want more than n/3. So there can be atmost only 2 elements whose frequencey is more than n/3. 
         * 
         * If it was more than n/2 than only 1 element would be possible. 
         * If it was more than n/4 than atmost 3 elements would be possible. 
         * 
         * Hence we can extend the version of moore and boyer's voting algorithm. 
         */
        
        List<Integer> result = new ArrayList<Integer>();

        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }

        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            
            if (count1 == 0 && candidate2 != nums[i]) {
                candidate1 = nums[i];
            } else if (count2 == 0 && candidate1 != nums[i])  {
                candidate2 = nums[i];
            } 

            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i =0; i < nums.length; i++) {

            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } 

        }    

        if (count1 > nums.length/3) {
            result.add(candidate1);
        } 

        if (count2 > nums.length/3) {
            result.add(candidate2);
        }
        return result;    
    }
}