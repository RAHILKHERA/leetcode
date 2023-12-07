public class LeetCode_1903_LargestOddNumberInString {
    
}

class Solution_LeetCode_1903_LargestOddNumberInString {
     public String largestOddNumber(String num) {
        
        int index = num.length() - 1;
        
        while (index > -1) {

            char ch = num.charAt(index);

            if (ch == '1' 
                || ch == '3' 
                || ch == '5'
                || ch == '7'
                || ch == '9') {

                return num.substring(0, index+1);
            }

            index--;
        }
        return "";
    }
}
