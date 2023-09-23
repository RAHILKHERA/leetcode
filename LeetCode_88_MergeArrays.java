public class LeetCode_88_MergeArrays {
    public static void main(String[] args) {

        int [] nums1 = {0,0,3,0,0,0,0,0,0};
        int [] nums2 = {-1,1,1,1,2,3};
        int m = 3;
        int n = 6;
        new Solution().merge(nums1, m, nums2, n);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i=0; i< nums2.length; i++) {
                nums1[i] = nums2[i];
            } 
        } else {
            int pointer_highest_nums1 = m - 1;
            int index_nums1 = nums1.length - 1;
            int index_nums2 = nums2.length - 1;
        
            while (index_nums2 >=0) {
                if (nums1[pointer_highest_nums1] <= nums2[index_nums2]) {
                    nums1[index_nums1] = nums2[index_nums2];
                    index_nums1--;
                    index_nums2--;
                } else {
                    nums1[index_nums1] = nums1[pointer_highest_nums1];
                    nums1[pointer_highest_nums1] = 0;
                    if (pointer_highest_nums1 != 0) {
                        pointer_highest_nums1--;
                    }
                    
                    index_nums1--;
                }
            }
            
        }      
    }
}