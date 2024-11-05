import java.util.ArrayList;
import java.util.List;

public class LeetCode_420_Q1 {

    public List<String> stringSequence(String target) {
        char[] charArray = target.toCharArray();
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int n = target.length();

        for (int i = 0; i < n; i++) {
            char ch = charArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j > ch) {
                    break;
                }
                builder.replace(i, i + 1, Character.toString(ch));
                result.add(builder.toString());
            }

        }

        return result;
    }
}
