public class LeetCode_136_1 {
    public int winningPlayerCount(int n, int[][] pick) {

        int[][] count = new int[n][11];

        for (int[] singlePick : pick) {
            count[singlePick[0]][singlePick[1]]++;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {

                if (count[i][j] > i) {
                    result++;
                }

            }
        }

        return result;
    }
}
