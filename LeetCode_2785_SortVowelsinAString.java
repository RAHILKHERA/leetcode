import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_2785_SortVowelsinAString {

    public static void main(String[] args) {
    
            new Solution_LeetCode_2785_SortVowelsinAString().sortVowels("lEetcOde");
    }
    
}

class Solution_LeetCode_2785_SortVowelsinAString {

    public String sortVowels(String s) {
        
        List<Character> vowelList = new ArrayList<>();

        for (char ch : s.toCharArray()) {

            if (isVowel(ch)) {
                vowelList.add(ch);
            }
        }

        if (vowelList.size() >0) {

            Collections.sort(vowelList);

            StringBuilder builder = new StringBuilder();
            int index = 0;
            for (char ch : s.toCharArray()) {
                
                if (isVowel(ch)) {
                builder.append(vowelList.get(index++));
                } else {
                    builder.append(ch);
                }
            }

            return builder.toString();
        }

        return s;
    }

    private boolean isVowel (char ch) {

      return ch == 'a' || ch == 'A' || 
             ch == 'e' || ch == 'E' || 
             ch == 'i' || ch == 'I' ||
             ch == 'o' || ch == 'O' ||
             ch == 'u' || ch == 'U';
    }
}
