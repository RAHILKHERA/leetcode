public class LeetCode_629_KInversionPairs {

    private static final int MOD = 1000000007;

    public int kInversePairs(int n, int k) {

        int[] prev = new int[k + 1];
        prev[0] = 1;

        for (int N = 1; N <= n; N++) {

            int[] curr = new int[k + 1];
            int total = 0;
            for (int K = 0; K <= k; K++) {

                if (K >= N) {
                    total -= prev[K - N];
                }

                total = (total + prev[K]) % MOD;
                curr[K] = total;
            }
            prev = curr;
        }

        return prev[k];
    }
}
