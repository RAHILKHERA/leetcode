import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindTheLongestSpecialSubstringThatOccursThriceI {

    @Test
    public void test1() {
        assertEquals(1, maximumLength("abcaba"));
    }

    @Test
    public void test2() {
        assertEquals(-1, maximumLength("abcdef"));
    }

    public int maximumLength(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = 0;
        int n = ch.length;
        Map<String, Integer> map = new HashMap<>();
        while (i < n) {
            if (j == n || ch[i] != ch[j]) {
                int len = j - i;
                for (int idx = 1; idx <= len; idx++) {
                    String key = ch[i] + "_" + idx;
                    int value = len - idx + 1;
                    if (map.containsKey(key)) {
                        int count = map.get(key);
                        count += value;
                        map.put(key, count);
                    } else {
                        map.put(key, value);
                    }
                }
                i = j;
            } else {
                j++;
            }
        }

        int max = -1;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) { // >= 3
                max = Math.max(max, Integer.parseInt(entry.getKey().split("_")[1]));
            }
        }

        return max;
    }
}
