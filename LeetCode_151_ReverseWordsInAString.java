public class LeetCode_151_ReverseWordsInAString {
    public static void main(String[] args) {
       System.out.println(new Solution_LeetCode_151_ReverseWordsInAString().reverseWords("    hello  computer    world  "));
    }
}

class Solution_LeetCode_151_ReverseWordsInAString {
    public String reverseWords(String s) {
        
        String trimed = s.trim();
        String words [] = trimed.split(" ");
        String result = "";
        for (int i = words.length -1 ; i >=0; i--) {
            if(!words[i].isEmpty()) {
                result += words[i] + " ";
            }
            
        }

        return result;
    }
}