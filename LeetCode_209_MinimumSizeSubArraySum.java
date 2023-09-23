public class LeetCode_209_MinimumSizeSubArraySum {

    public static void main(String[] args) {
        new Solutiom_LeetCode_209_MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}

class Solutiom_LeetCode_209_MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        
        int res = nums.length + 1, sum = 0, left = 0;

        for (int right = 0; right <nums.length; right++) {
            sum += nums[right];
            while (sum > target && left < nums.length) {
                sum -= nums[left++];
            }

            if (sum == target) {
                res = Math.min(res, right - left + 1);
            }
        }

        if (res == nums.length +1) {
            return 0;
        }

        return res;

    }

}