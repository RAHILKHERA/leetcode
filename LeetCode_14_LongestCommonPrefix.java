public class LeetCode_14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = { "12flower","flow","flight" };
        System.out.println(new Solution_LeetCode_14_LongestCommonPrefix().longestCommonPrefix(strs));
    }
}

class Solution_LeetCode_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String baseString = strs[0];
        // String longestCommonPrefix = "";
        // boolean prefixFound = false;

        // for (int i = 1; i < strs.length; i++) {

        //     int length = baseString.length() < strs[i].length() ? baseString.length() : strs[i].length();
        //     for (int j = 0; j < length; j++) {

        //         char ch = strs[i].charAt(j);
        //         if (baseString.charAt(j) == ch) {
        //             longestCommonPrefix += ch;
        //             prefixFound = true;
        //         } else {
        //             break;
        //         }
        //     }

        //     if (prefixFound) {
        //         baseString = longestCommonPrefix;
        //         longestCommonPrefix = "";
        //     } else {
        //         break;
        //     }
        // }

        // if (!prefixFound) {
        //     return "";
        // }

        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(baseString) !=0){
                baseString = baseString.substring(0, baseString.length()-1);
            }

            if (baseString.isEmpty()) {
                break;
            }
        }
        return baseString;
    }
}