import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_131_PalidromePartioning {

    @Test
    public void test1() {

        List<List<String>> result = new ArrayList<>();

        List<String> partiion1 = new ArrayList<>();
        partiion1.add("a");
        partiion1.add("a");
        partiion1.add("b");
        result.add(new ArrayList<>(partiion1));

        partiion1 = new ArrayList<>();
        partiion1.add("aa");
        partiion1.add("b");
        result.add(new ArrayList<>(partiion1));

        assertEquals(partiion1, partition("aab"));
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();

        dfs(s, result, partition, 0);

        return result;
    }

    private void dfs(String s, List<List<String>> result, List<String> partition, int index) {

        if (index >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                partition.add(s.substring(index, i + 1));

                dfs(s, result, partition, i + 1);

                partition.remove(partition.size() - 1);

            }

        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
