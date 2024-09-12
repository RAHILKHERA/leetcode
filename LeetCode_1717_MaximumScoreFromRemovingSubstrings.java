import java.util.Stack;

public class LeetCode_1717_MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {

        int score = 0;

        String subString = removeSubString(s, x > y);

        score = ((s.length() - subString.length()) / 2) * Math.max(x, y);

        String finalString = removeSubString(subString, !(x > y));

        score += ((subString.length() - finalString.length()) / 2) * Math.min(x, y);

        return score;
    }

    private String removeSubString(String s, boolean ab) {

        Stack<Character> stack = new Stack<>();
        char[] chArray = s.toCharArray();

        if (ab) {
            for (char ch : chArray) {

                if (ch == 'b' && !stack.empty() && stack.peek() == 'a') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }

            }
        } else {
            for (char ch : chArray) {

                if (ch == 'a' && !stack.empty() && stack.peek() == 'b') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }

            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }
}
