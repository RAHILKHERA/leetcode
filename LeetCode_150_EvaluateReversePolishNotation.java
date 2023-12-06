import java.util.Stack;

public class LeetCode_150_EvaluateReversePolishNotation {
    
}

class Solution_LeetCode_150_EvaluateReversePolishNotation {
     public int evalRPN(String[] tokens) {
     
        int operand1 = 0;
        int operand2 = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            switch (token) {
                case "+" : operand1 = stack.pop();
                           operand2 = stack.pop();
                           stack.push(operand2 + operand1);
                           break;
                case "-" : operand1 = stack.pop();
                           operand2 = stack.pop();
                           stack.push(operand2 - operand1);
                           break;
                case "*" : operand1 = stack.pop();
                           operand2 = stack.pop();
                           stack.push(operand2 * operand1);
                           break;
                case "/" : operand1 = stack.pop();
                           operand2 = stack.pop();
                           stack.push(operand2 / operand1);
                           break;
                default : stack.push(Integer.valueOf(token));

            }
        }

        return stack.pop();
    }
}