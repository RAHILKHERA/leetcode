public class LeetCode_3005_CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {

        int freq[] = new int[101];
        int max = 0;

        for (int i : nums) {
            freq[i]++;
            if (max < freq[i]) {
                max = freq[i];
            }
        }

        int count = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == max) {
                count++;
            }
        }

        return count * max;
    }
}
