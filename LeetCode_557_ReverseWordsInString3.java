public class LeetCode_557_ReverseWordsInString3 {
    public static void main(String[] args) {
        new Solution_LeetCode_557_ReverseWordsInString3().reverseWords("Let's take LeetCode contest");
    }
}

class Solution_LeetCode_557_ReverseWordsInString3 {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0, k = 0; 
        while (j <=s.length()) {
            
            // For reversing last word. 
            if (j == s.length()) {
                j--;    
                while ( j >= i) {
                    result.append(s.charAt(j));
                    j--;
                }
                break;
            }


            char ch = s.charAt(j); 
            if (ch != ' ') {
                j++;
            } else {
                k = j;
                j--;
                while ( j >= i) {
                    result.append(s.charAt(j));
                    j--;
                }
                result.append(' ');
                k++;
                i = k;
                j = k;
            }
        }

        return result.toString();
    }
}
