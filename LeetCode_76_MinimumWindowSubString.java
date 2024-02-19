import java.util.HashMap;
import java.util.Map;

public class LeetCode_76_MinimumWindowSubString {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) {
            return "";
        }

        if (s.length() < t.length()) {
            return "";
        }

        if (s.equals(t)) {
            return s;
        }

        /*
         * Character frequency map of string t.
         */
        Map<Character, Integer> tMap = new HashMap<>();
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            tMap.compute(c, (key, count) -> count == null ? 1 : count + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int have = 0, need = tMap.size(), min = Integer.MAX_VALUE;
        int result[] = new int[] { -1, -1 };
        char[] sCharArray = s.toCharArray();
        int left = 0, right = 0;

        while (right < sCharArray.length) {
            if (tMap.containsKey(sCharArray[right])) {
                windowMap.compute(sCharArray[right], (key, value) -> value == null ? 1 : value + 1);
                if (windowMap.get(sCharArray[right]).equals(tMap.get(sCharArray[right]))) {
                    have++;
                }

                while (need == have) {

                    if (right - left + 1 < min) {
                        min = right - left + 1;
                        result[0] = left;
                        result[1] = right;
                    }

                    if (windowMap.containsKey(sCharArray[left])) {
                        windowMap.compute(sCharArray[left], (key, value) -> value - 1);
                        if (windowMap.get(sCharArray[left]) < tMap.get(sCharArray[left])) {
                            have--;
                        }
                    }
                    left++;

                }
            }
            right++;
        }

        if (min != Integer.MAX_VALUE) {
            return s.substring(result[0], result[1] + 1);
        }
        return "";
    }

}
