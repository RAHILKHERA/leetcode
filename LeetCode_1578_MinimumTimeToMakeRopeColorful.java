public class LeetCode_1578_MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        // new LeetCode_1578_MinimumTimeToMakeRopeColorful().minCost("abaac", new int[]
        // { 1, 2, 3, 4, 5 });
        // new LeetCode_1578_MinimumTimeToMakeRopeColorful().minCost("abc", new int[] {
        // 1, 2, 3 });
        new LeetCode_1578_MinimumTimeToMakeRopeColorful().minCost("bbbaaa", new int[] { 4, 9, 3, 8, 8, 9 });
    }

    public int minCost(String colors, int[] neededTime) {
        int i = 0;
        int minCost = 0;
        char[] colorChar = colors.toCharArray();
        int n = colors.length();
        while (i < n - 1) {

            int j = i + 1;
            int currentTime = neededTime[i], max = neededTime[i];
            while (j < n && colorChar[i] == colorChar[j]) {

                currentTime += neededTime[j];
                max = max > neededTime[j] ? max : neededTime[j];
                j++;
            }

            minCost += currentTime - max;
            i = j;
        }

        return minCost;
    }
}
