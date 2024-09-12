import java.util.Stack;

public class LeetCode_678_ValidParenthesisString {
    public boolean checkValidString(String s) {

        int leftMin = 0, leftMax = 0;

        for (char ch : s.toCharArray()) {

            switch (ch) {
                case '(':
                    leftMin++;
                    leftMax++;
                    break;
                case '*':
                    leftMin--;
                    leftMin = leftMin < 0 ? 0 : leftMin;
                    leftMax++;
                    break;
                case ')':
                    leftMax--;
                    if (leftMax < 0) {
                        return false;
                    }
                    leftMin--;
                    leftMin = leftMin < 0 ? 0 : leftMin;
            }

        }

        return 0 >= leftMin && 0 <= leftMax;
    }

    public boolean checkValidString(String s, boolean second) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Check if char = '(', push its index into stack open
            if (ch == '(') {
                open.push(i);
            } else
            // Check if char = '*', push its index into stack star
            if (ch == '*') {
                star.push(i);
            } else if (ch == ')') {
                // Check if open stack is not empty, pop from open
                if (!open.isEmpty()) {
                    open.pop();
                } else
                // If open is empty, Check if star is not empty, pop from star
                if (!star.isEmpty()) {
                    star.pop();
                } else
                // If both are empty, return false
                {
                    return false;
                }
            }
        }

        // Check for any leftovers
        // Check if any element is still present in open
        while (!open.isEmpty()) {
            // If star is empty, s is invalid, return false
            if (star.isEmpty()) {
                return false;
            } else
            // Check if top index in open < top index in star
            if (open.peek() < star.peek()) {
                // pop from both open and star
                open.pop();
                star.pop();
            } else
            // If top index in open > top index in star, s is invalid
            {
                return false;
            }
        }
        return true;
    }
}
