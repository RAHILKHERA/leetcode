import java.util.ArrayDeque;

public class LeetCode_402_RemoveKDigits {
    public String removeKdigits(String num, int k) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (Character ch : num.toCharArray()) {

            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                k--;
                stack.pop();

            }
            stack.push(ch);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        builder.reverse();

        for (int i = 0; i < builder.length();) {
            if (builder.charAt(i) == '0') {
                builder.deleteCharAt(i);
            } else {
                break;
            }
        }

        if (builder.toString().isBlank()) {
            return "0";
        }

        return builder.toString();
    }
}
