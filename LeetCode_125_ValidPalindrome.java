public class LeetCode_125_ValidPalindrome {
    public static void main(String[] args) {

        new Solution_LeetCode_125_ValidPalindrome().isPalindrome("race a car");
    }
}

class Solution_LeetCode_125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        
        
        if (s.isBlank()) {
            return true;
        }

        StringBuilder filterString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch >= 'A' && ch <='Z' ) {
                int ascii = ch;
                ascii += 32;
                ch = (char) ascii;
                filterString.append(ch);
            } else if   ((ch >= '0' && ch <='9') || (ch >='a' && ch <='z')) {
                filterString.append(ch);
            }
        } 

        int i = 0;
        int j = filterString.length() - 1;
        int length = filterString.length();
        
        while ( i <= length/2 && j >= length/2 ) {
            if (filterString.charAt(i) != filterString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
