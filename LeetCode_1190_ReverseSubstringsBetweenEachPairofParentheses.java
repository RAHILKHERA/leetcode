import java.util.Stack;

public class LeetCode_1190_ReverseSubstringsBetweenEachPairofParentheses {

    public String reverseParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            }

            if (ch == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int currentIndex = 0, direction = 1; currentIndex < s.length(); currentIndex += direction) {

            char ch = s.charAt(currentIndex);

            if (ch == ')' || ch == '(') {
                currentIndex = pair[currentIndex];
                direction = -direction;
            } else {
                builder.append(ch);
            }

        }

        return builder.toString();
    }
}