public class LeetCode_100308_SpecialArrayII {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // Create the specialPrefix array
        int[] specialPrefix = new int[n];
        for (int i = 1; i < n; i++) {
            specialPrefix[i] = specialPrefix[i - 1] + (nums[i - 1] % 2 != nums[i] % 2 ? 1 : 0);
        }

        boolean[] results = new boolean[m];
        for (int i = 0; i < m; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            // Calculate the number of special pairs in the range [from, to]
            int specialCount = specialPrefix[to] - specialPrefix[from];

            // The subarray is special if and only if the number of special pairs equals the
            // length of the subarray minus one
            results[i] = (specialCount == (to - from));
        }

        return results;
    }

}
