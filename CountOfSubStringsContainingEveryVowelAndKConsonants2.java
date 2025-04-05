import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CountOfSubStringsContainingEveryVowelAndKConsonants2 {

    @Test
    public void test1() {
        assertEquals(3, countOfSubstrings("ieaouqqieaouqq", 1));
    }

    @Test
    public void test2() {
        assertEquals(2, countOfSubstrings("aadieuoh", 1));
    }

    public long countOfSubstrings(String word, int k) {
        char[] ch = word.toCharArray();
        int n = ch.length;
        int currK = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        long count = 0;
        while (right < n) {

            if (isVowel(ch[right])) {
                map.merge(ch[right], 1, Integer::sum);
            } else {
                currK++;
            }

            if (currK == k && map.size() == 5) {
                count++;
            }

            if (currK > k || right == n - 1) {

                if (!isVowel(ch[right])) {
                    currK--;
                }

                while (left < right) {
                    if (isVowel(ch[left])) {
                        int vowelCount = map.get(ch[left]);
                        vowelCount--;
                        if (vowelCount == 0) {
                            map.remove(ch[left]);
                        } else {
                            map.put(ch[left], vowelCount);
                        }

                    } else {
                        currK--;
                    }
                    if (currK == k && map.size() == 5) {
                        count++;
                    }
                    left++;
                }
                left = right;
                if (!isVowel(ch[right])) {
                    currK++;
                }
            }

            right++;
        }

        return count;
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
}
