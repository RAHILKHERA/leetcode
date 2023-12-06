import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode_316_RemoveDuplicateLetters {

    public static void main(String[] args) {
        //assertEquals("abc", new Solution_LeetCode_316_RemoveDuplicate().removeDuplicateLetters("bcabc")); 
        assertEquals("acdb", new Solution_LeetCode_316_RemoveDuplicate().removeDuplicateLetters("cbacdcbc")); 
    }
    
}

class Solution_LeetCode_316_RemoveDuplicate {
    public String removeDuplicateLetters(String s) {
        ArrayList<String> subSequence = null;
        StringBuffer str = new StringBuffer();
        for (int i = 0; i< s.length(); i++) {
            String subString = s.substring(i, i+1);
            int index = str.indexOf(subString);
            if (index == -1) {
                str.append(subString);
                subSequence = new ArrayList<>();
                subSequence.add(str.toString());
            } else {
                str.deleteCharAt(index);
                str.append(subString);
                subSequence.add(str.toString());

            }
        }
        Collections.sort(subSequence);
        return subSequence.get(0);
    }
}
