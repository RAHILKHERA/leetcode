public class LeetCode_3244_ShortestDistanceAfterRoadAdditionQueries2 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        int m = queries.length;
        int[] result = new int[m];
        int[] distances = new int[n];

        for (int i = 0; i < distances.length; i++) {
            distances[i] = i;
        }

        int index = 0;

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            if (u == 0 && v == n - 1) {

                for (int j = index; j < m; j++) {
                    result[index] = 1;
                    index++;
                }

                return result;
            }

            int diff = u - v + 1;

            for (int j = u + 1; j < distances.length; j++) {
                distances[j] += diff;
            }

            result[index++] = distances[n - 1];

        }

        return result;
    }
}
