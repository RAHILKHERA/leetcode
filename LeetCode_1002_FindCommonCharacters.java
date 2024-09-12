import java.util.ArrayList;
import java.util.List;

public class LeetCode_1002_FindCommonCharacters {
    public List<String> commonChars(String[] words) {

        List<String> result = new ArrayList<>();
        int[] current = new int[26];
        int[] previous = new int[26];

        for (char ch : words[0].toCharArray()) {
            current[ch - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {

            previous = current;
            current = new int[26];

            for (char ch : words[i].toCharArray()) {
                current[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                current[j] = Math.min(current[j], previous[j]);
            }

        }

        for (int i = 0; i < 26; i++) {
            String ch = Character.toString(i + 'a');
            while (current[i] > 0) {
                result.add(ch);
                current[i]--;
            }
        }

        return result;
    }
}
