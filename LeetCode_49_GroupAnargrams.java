import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_49_GroupAnargrams {
    public static void main(String[] args) {
        // String [] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = { "bdddddddddd", "bbbbbbbbbbc" };
        new Solution_LeetCode_49_GroupAnargrams().groupAnagrams(strs);
    }
}

class Solution_LeetCode_49_GroupAnargrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {

            // char[] count = new char[26];

            // for (char c : str.toCharArray()) {
            // count[c - 'a']++;
            // }

            // String encoding = new String(count);
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String encoding = new String(temp);

            if (map.containsKey(encoding)) {
                List<String> values = map.get(encoding);
                values.add(str);

            } else {
                List<String> values = new ArrayList<String>();
                values.add(str);
                map.put(encoding, values);
            }

        }

        return new ArrayList<>(map.values());
    }
}
