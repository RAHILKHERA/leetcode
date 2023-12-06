import java.util.Stack;

public class LeetCode_20_ValidParantheses {
    
}

class Solution_LeetCode_20_ValidParantheses {

    public boolean isValid (String s) {


        if (s.length() %2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        

        for (int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.pop() != '(') {
                    return false;
                } else if (ch == '}' && stack.pop() != '{') {
                    return false;
                } else if (ch == ']' && stack.pop() != '[') { 
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
