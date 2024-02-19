import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_1239_MaximumLengthOfAConcatedStringWithUniqueCharacters {

    @Test
    public void test() {

        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");

        assertEquals(4, maxLength(arr));

    }

    public int maxLength(List<String> arr) {

        if (arr.size() == 1) {
            if (hasDuplicate(arr.get(0), "")) {
                return 0;
            }
            return arr.get(0).length();
        }

        int n = arr.size();
        String temp = "";
        return dfs(arr, n, 0, temp);
    }

    private int dfs(List<String> arr, int len, int index, String temp) {

        if (index >= len) {
            return temp.length();
        }

        int include = 0;
        int exclude = 0;

        if (!hasDuplicate(arr.get(index), temp)) {

            include = dfs(arr, len, index + 1, arr.get(index) + temp);

        }

        exclude = dfs(arr, len, index + 1, temp);

        if (include > exclude) {
            return include;
        }

        return exclude;

    }

    private boolean hasDuplicate(String s1, String s2) {

        int[] count = new int[26];
        char[] charArray = s1.toCharArray();

        for (char ch : charArray) {

            if (count[ch - 'a'] > 0) {
                return true;
            }
            count[ch - 'a']++;
        }

        charArray = s2.toCharArray();

        for (char ch : charArray) {
            if (count[ch - 'a'] > 0) {
                return true;
            }
        }

        return false;
    }

}
