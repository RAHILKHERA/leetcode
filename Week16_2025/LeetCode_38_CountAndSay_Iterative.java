package Week16_2025;

/**
 * LeetCode Problem: 38 Count and Say. 
 * Problem Link:
 * https://leetcode.com/problems/count-and-say/?envType=daily-question&envId=2025-04-18
 * 
 * Definitions :
 * #1 Base Case : n = 1 => "1". 
 * #2 CountNSay : If x appears y times continuosly in current encoded string, then in next encoded string it will be represented as "yx".
 * 
 * Task : For given 'n', find the encoded string. 
 * 
 * Observation :
 * #1 Base case n = 1 => result = "1".
 * #2 Each state (n) is dependent on it's previous state (n-1). 
 * #3 Once encoding from n-1 state is received, the encoding for current state can be calculated.  
 * #4 Recursion relation of f(n) = encode(f(n-1)).
 * 
 * Approach:
 * 1) Implement Recusrison with base case n = 1.
 * 2) To encode the string, use sliding window protocol, keep a counter and expand the window till you get same characters for both the pointers.
 * 3) When unequal characters are found or end of the string is reached, add current count and character to the string. 
 * 4) Memoize the results for each n, so for next test, in case that n is required previous results can be used as encoding operation is a costly operation.  
 * 
 * Time Complexity: O(2^n) : At every stage, the length of the enoded string increases twice its previous stage. And in worse case none of the previous stage calculations are available.
 * Space Complexity: O(2^n) : Storing all the generated strings.  
 */

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_38_CountAndSay_Iterative {

    @Test
    public void test2() {
        assertTrue("1".equals(countAndSay(1)));
    }

    @Test
    public void test3() {
        assertTrue("312211".equals(countAndSay(6)));
    }

    @Test
    public void test1() {
        assertTrue("1211".equals(countAndSay(4)));
    }

    private static Map<Integer, String> map = new HashMap<>();

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        String current = "1";
        for (int i = 2; i <= n; i++) {
            if (map.containsKey(i)) {
                current = map.get(i);
            } else {
                current = encode(current);
                map.put(i, current);
            }

        }
        return current;

    }

    private String encode(String say) {
        char[] ch = say.toCharArray();
        int n = ch.length;
        int left = 0, right = 0;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        while (right < n) {
            if (ch[left] == ch[right]) {
                count++;
            } else {
                builder.append(count);
                builder.append(ch[left]);
                left = right;
                count = 1;
            }
            right++;
        }
        builder.append(count);
        builder.append(ch[left]);
        return builder.toString();
    }
}
