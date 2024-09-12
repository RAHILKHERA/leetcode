public class LeetCode_100310_SpecialArrayI {
    public boolean isArraySpecial(int[] nums) {

        int i = 0, j = i + 1;

        while (j < nums.length) {

            if ((nums[i] % 2 == 0 && nums[j] % 2 == 0) || (nums[i] % 2 != 0 && nums[j] % 2 != 0)) {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}
