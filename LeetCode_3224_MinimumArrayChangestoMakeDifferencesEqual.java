import java.util.HashSet;
import java.util.Set;

public class LeetCode_3224_MinimumArrayChangestoMakeDifferencesEqual {
    public int minChanges(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i] > nums[n - i - 1] ? nums[i] - nums[n - i - 1] : nums[n - i - 1] - nums[i]);
        }

        int minChanges = Integer.MAX_VALUE;
        for (int X : set) {
            int changes = 0;
            for (int i = 0; i < n / 2; i++) {

                int diff = nums[i] > nums[n - i - 1] ? nums[i] - nums[n - i - 1] : nums[n - i - 1] - nums[i];

                if (diff != X) {
                    int greaterNumber = (nums[i] > nums[n - i - 1] ? nums[i] : nums[n - i - 1]) + (X - diff);
                    int smallerNumber = (nums[i] < nums[n - i - 1] ? nums[i] : nums[n - i - 1]) - (X - diff);
                    changes += (greaterNumber <= k || smallerNumber >= 0) ? 1 : 2;
                }

            }

            minChanges = changes < minChanges ? changes : minChanges;
        }

        return minChanges;
    }
}
