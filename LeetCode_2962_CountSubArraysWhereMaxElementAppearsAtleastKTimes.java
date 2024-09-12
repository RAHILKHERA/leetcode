public class LeetCode_2962_CountSubArraysWhereMaxElementAppearsAtleastKTimes {
    public long countSubarrays(int[] nums, int k) {

        int max = nums[0];

        for (int i : nums) {
            max = i > max ? i : max;
        }

        int count = 0, left = 0, right = 0;
        long result = 0;

        while (right < nums.length) {

            if (nums[right] == max) {
                count++;
            }

            while (count > k || (nums[left] != max && left < nums.length && count == k)) {

                if (nums[left] == max) {
                    count--;
                }
                left++;
            }

            if (count == k) {
                result += left + 1;
            }

            right++;

        }

        return result;
    }
}
