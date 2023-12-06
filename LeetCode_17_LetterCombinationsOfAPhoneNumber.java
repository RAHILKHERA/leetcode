import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_17_LetterCombinationsOfAPhoneNumber {

}

class Solution_LeetCode_17_LetterCombinationsOfAPhoneNumber {

    private static Map<Character, String> digitMap = new HashMap<>();

    static {
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.isEmpty()) {
            return result;
        }
        String charRepresentation = digitMap.get(digits.charAt(0));
        for (int j = 0; j < charRepresentation.length(); j++) {
            result.add(String.valueOf(charRepresentation.charAt(j)));
        }

        for (int i = 1; i < digits.length(); i++) {

            charRepresentation = digitMap.get(digits.charAt(i));

            List<String> interResult = new ArrayList<>();

            for (int j = 0; j < charRepresentation.length(); j++) {

                char ch = charRepresentation.charAt(j);
                for (int k = 0; k < result.size(); k++) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(result.get(k)).append(ch);
                    interResult.add(builder.toString());
                }
            }
            result.clear();
            result.addAll(interResult);
        }

        return result;
    }
}
