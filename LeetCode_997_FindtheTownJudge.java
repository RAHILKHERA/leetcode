public class LeetCode_997_FindtheTownJudge {

    public int findJudge(int n, int[][] trust) {

        int[] outEdges = new int[n + 1];
        int[] inEdges = new int[n + 1];

        for (int[] i : trust) {
            outEdges[i[0]]++;
            inEdges[i[1]]++;
        }

        for (int i = 1; i < n + 1; i++) {

            if (outEdges[i] == 0 && inEdges[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
