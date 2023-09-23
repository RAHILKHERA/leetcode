import static org.junit.Assert.assertEquals;

public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
         assertEquals(3,new Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
         assertEquals(1,new Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
         assertEquals(3,new Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
         assertEquals(0,new Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
         assertEquals(1,new Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("p"));
         assertEquals(3,new Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
        assertEquals(7,new Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkewabcde"));

    }
}

class Solution_LeetCode_3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        
    //     if (s.length() == 0 || s.length() == 1)   {
    //         return s.length();
    //     }
        
    //     int maxLength = 0;
    //     int currentLength = 0;
    //     int left = 0, right = 0;
    //     String subString = "";


    //    while ( right < s.length() ) {

            
    //         char ch = s.charAt(right);

    //         if (subString.indexOf(ch) == -1) {
    //             subString += ch;
    //             right++;
    //         } else {
    //              subString = "";
    //              currentLength = right - left;
    //              maxLength = currentLength > maxLength ? currentLength : maxLength;
    //              left++;
    //              if (s.length() - left < maxLength) {
    //                 break; 
    //              }
    //              right = left;    
    //         }
    //    }
       
    //     currentLength = right - left;
    //     maxLength = currentLength > maxLength ? currentLength : maxLength;

    //     return maxLength;   

    int maxLength = 0;
    for(int right = 0, left = 0; right < s.length(); right++){
        int indexOfSubstring = s.indexOf(s.charAt(right), left);
        if(indexOfSubstring != right){
            left = indexOfSubstring + 1;
        }
        maxLength = Math.max(maxLength, right-left+1);
    }

    return maxLength;
    }
}