import java.util.Arrays;

public class LeetCode_552_StudentAttendanceRecord2 {

    private static final int modulo = 1000000007;

    private int[][][] dp;

    public int checkRecord(int n) {

        /**
         * First dimension for the presence.
         * 
         * Second dimension for the absence. As number of absence has to be less than 2
         * (either 0 or 1), size 2 is sufficient.
         * 
         * Third dimension for the consecutive late. As number of consecutive late has
         * to be less than 3 (0, 1 or 2) size 3 is sufficient.
         * 
         */

        dp = new int[n + 1][2][3];

        /**
         * Top - Down Approach
         */
        // for (int[][] matrix : dp) {
        //     for (int[] row : matrix) {
        //         Arrays.fill(row, -1);
        //     }
        // }

        /**
         * Bottom-Up Approach
         */

        // If day is 0 and other
        for (int A = 0; A < 2; A++) {
            for (int L = 0; L < 3; L++) {
                dp[0][A][L] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int A = 0; A < 2; A++) {
                for (int L = 0; L < 3; L++) {
                    long absent = A + 1 < 2 ? dp[i - 1][A + 1][0] : 0;
                    long late = L + 1 < 3 ? dp[i - 1][A][L + 1] : 0;
                    long presence = dp[i - 1][A][0];
                    dp[i][A][L] = (int) ((absent + late) % modulo + presence) % modulo;
                }
            }
        }

        // return solve(n, 0, 0);
        return dp[n][0][0];

    }

    private int solve(int n, int absence, int conLate) {

        if (absence >= 2 || conLate >= 3) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (dp[n][absence][conLate] != -1) {
            return dp[n][absence][conLate];
        }

        int absent = solve(n - 1, absence + 1, 0);
        int late = solve(n - 1, absence, conLate + 1);
        int presence = solve(n - 1, absence, 0);

        dp[n][absence][conLate] = (((absent + late) % modulo) + presence) % modulo;

        return dp[n][absence][conLate];

    }

}
