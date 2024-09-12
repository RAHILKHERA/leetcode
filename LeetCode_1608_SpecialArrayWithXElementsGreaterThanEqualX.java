public class LeetCode_1608_SpecialArrayWithXElementsGreaterThanEqualX {
    public int specialArray(int[] nums) {

        int N = nums.length;
        int[] freq = new int[N + 1];

        for (int num : nums) {
            freq[Math.min(N, num)]++;
        }

        int currentSum = 0;
        for (int i = N; i >= 0; i--) {

            currentSum += freq[i];

            if (currentSum == i) {
                return i;
            }

        }

        return -1;
    }
}
