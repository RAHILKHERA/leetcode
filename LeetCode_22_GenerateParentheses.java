import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_22_GenerateParentheses {
    public static void main(String[] args) {
        new Solution_LeetCode_22_GenerateParentheses().generateParenthesis(3);
    }
}

class Solution_LeetCode_22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        result.add("()");

        if (n == 1) {
            return result;
        }

        HashSet<String> newResult = new HashSet<>(result);
        
        generateNextString(n, newResult);

        return new ArrayList<>(newResult);
    }

    private void generateNextString(int target, HashSet<String> result) {

        if (target == 0) {
            return;
        }
        HashSet<String> newResult = new HashSet<>();
        for (String parenthesesString : result) {
            String openP = "()";
            String closeP = ")(";
            StringBuilder openPBuilder = new StringBuilder();
            StringBuilder closePBuilder = new StringBuilder();
            for (int i = 0; i < parenthesesString.length(); i++) {

                char ch = parenthesesString.charAt(i);

                if (ch == '(') {
                    openPBuilder.append(ch).append(openP);
                    closePBuilder.append(ch).append(closeP);
                }  else {
                    openPBuilder.append(ch);
                    closePBuilder.append(ch);
                }
            }

            newResult.add(openPBuilder.toString());
            newResult.add(closePBuilder.toString());
        }
        
        result = newResult;
        generateNextString(--target, result);
    }

}
