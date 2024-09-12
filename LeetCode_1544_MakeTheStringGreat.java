import java.util.ArrayDeque;

public class LeetCode_1544_MakeTheStringGreat {
    public String makeGood(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(ch);
            } else if ((ch >= 'a' && ch <= 'z' && stack.peek().equals((char) (ch - 32))) || (ch >= 'A' && ch <= 'Z'
                    && stack.peek().equals((char) (ch + 32)))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }

    public String makeGoodEfficient(String s) {

        if (s.length() == 0 || s.length() == 1)
            return s;

        StringBuilder sb = new StringBuilder();

        sb.append(s);

        int i = 0;

        while (i < sb.length() - 1) {
            char leftChar = sb.charAt(i);
            char rightChar = sb.charAt(i + 1);

            if (Math.abs(leftChar - rightChar) == 32) {
                sb.delete(i, i + 2);
                if (i > 0)
                    i--;
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
