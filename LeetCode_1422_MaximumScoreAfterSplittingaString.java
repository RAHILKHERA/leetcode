public class LeetCode_1422_MaximumScoreAfterSplittingaString {
    public int maxScore(String s) {

        int zeros = 0, ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            }
        }

        int max = 0, current = 0;
        for (int i = 0; i < s.length() - 1; i++) {

            char ch = s.charAt(i);
            switch (ch) {
                case '0':
                    zeros++;
                    break;
                case '1':
                    ones--;
            }
            current = zeros + ones;
            if (max < current) {
                max = current;
            }

        }

        return max;
    }
}
