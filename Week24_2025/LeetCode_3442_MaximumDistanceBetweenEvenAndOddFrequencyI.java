package Week24_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 3442 Maximum distance between even and odd frequency I
 * 
 * Problem Link:
 * https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/?envType=daily-question&envId=2025-06-10
 * 
 * Input:
 * - String s
 * 
 * Constraints:
 * 3 <= s.length <= 100
 * s consists only of lowercase English letters.
 * s contains at least one character with an odd frequency and one with an even frequency.
 * 
 * Definition : diff = x - y, x = has an odd frequency in the string, y = has an even frequency in the string. 
 *            
 * Task: Find the maximum difference of x - y. 
 * 
 * Observations:
 * #1. As string contains only lowercase English letters, integer array of size 26 can be used to calculate frequency. 
 * #2. Calculate frequency of each character. 
 * #3. To maximize x - y, maximize x and minimize y. 
 *     => Find maximum odd frequency (x). 
 *     => Find minimum even frequency (y). 
 *    
 * Approach:
 * 1. Traverse the string and calculate the frequency of each character.
 * 2. Traverse the frequency array,
 *    => Special Case: frequency = 0, the frequency of characters not appearing in the string.
 *      -> This should be explicitly ignored to avoid counting it in minEven.
 *    => If frequency is even, calculate minEven frequency.
 *    => If frequency is odd, calculate maxOdd frequency.
 * 3. Return maxOdd - minEven.
 * 
 * Time Complexity: O(n)
 * |                       Component                            |                Time               |
 * | ---------------------------------------------------------- |---------------------------------- |
 * |  Traverse all characters of the string to calculate        |        O(n)                       | 
 * |  frequency of each character                               |                                   |
 * |  Traverse frequency array                                  |        O(26)                      |       
 * |------------------------------------------------------------|-----------------------------------|
 * |                  Total Complexity                          |  O(n + 26) => O(n)                |
 * 
 * 
 * Space Complexity: O(1)
 * |                        Component                           |                  Space            |
 * | ---------------------------------------------------------- |---------------------------------- |
 * |   Frequency array of size 26 is used.                      |        O(26)                      |
 * |----------------------------------------------------------- |-----------------------------------|
 * | Total Complexity                                           |        O(26) => O(1)              |
 *
 */


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_3442_MaximumDistanceBetweenEvenAndOddFrequencyI {
    
    @Test
    public void test1() {
        assertEquals(3, maxDifference("aaaaabbc"));
    }

    @Test
    public void test2() {
        assertEquals(1, maxDifference("abcabcab"));
    }

    @Test
    public void test3() {
        assertEquals(-1, maxDifference("tzt"));
    }
    
    public int maxDifference(String s) {
        
        int maxOdd = 0;
        int minEven = s.length();
        

        int [] freq = new int [26];
        for (char ch : s.toCharArray()) {
            freq[ch -'a']++;
        }

        for (int f : freq) {
            if (f == 0)
                continue;
            if ((f & 1) == 0) {
                minEven = Math.min(minEven, f);
            } else {
                maxOdd = Math.max(maxOdd, f);
            }
        }
        
        return maxOdd - minEven;
    }
}
