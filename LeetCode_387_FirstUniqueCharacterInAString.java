
import java.util.stream.IntStream;

public class LeetCode_387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int result = -1;
        int[] freq = new int[26];

        s.chars().forEach(c -> freq[c - 'a']++);

        result = IntStream.range(0, s.length())
                .filter(i -> freq[s.charAt(i) - 'a'] == 1)
                .findFirst()
                .orElse(-1);

        return result;
    }

}
