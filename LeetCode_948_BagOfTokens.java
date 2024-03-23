import java.util.Arrays;

public class LeetCode_948_BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {

        int res = 0, score = 0, left = 0, right = tokens.length - 1;

        Arrays.sort(tokens);

        while (left <= right) {

            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
                res = Math.max(res, score);
            } else if (score > 0) {
                power += tokens[right];
                right--;
                score--;
            } else {
                break;
            }
        }

        return res;
    }
}
