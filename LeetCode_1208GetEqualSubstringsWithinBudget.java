public class LeetCode_1208GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {

        if (maxCost == 0) {
            return 1;
        }

        int maxLength = 0;
        int n = s.length();
        int[] cost = new int[n];

        for (int i = 0; i < cost.length; i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            cost[i] = Math.abs(sCh - tCh);
        }

        int sum = 0, left = 0, right = 0;

        while (right < n) {

            if (sum + cost[right] <= maxCost) {
                sum += cost[right];
                right++;
            } else {

                maxLength = Math.max(maxLength, right - left);
                while (sum + cost[right] > maxCost) {
                    sum -= cost[left];
                    left++;
                }

            }
        }

        maxLength = Math.max(maxLength, right - left);

        return maxLength;
    }
}
