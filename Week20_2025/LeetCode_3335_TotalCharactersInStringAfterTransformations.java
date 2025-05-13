package Week20_2025;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_3335_TotalCharactersInStringAfterTransformations {

    /**
     * @RAHILKHERA
     * 
     * LeetCode Problem: 3335 Total characters in string after transformations. 
     * Problem Link: https://leetcode.com/problems/total-characters-in-string-after-transformations-i/?envType=daily-question&envId=2025-05-13
     *
     * Input :
     *  - String s
     *  - Number of transformations : t 
     * 
     * Definition : Transformation:
     * - char 'z' is replaced by 'ab'.
     * - Other characters are replaced by next characters, i.e. c will be replaced by d. 
     * 
     * Constraints:
     * 1 <= s.length <= 10^5
     * s consists only of lowercase English letters.
     * 1 <= t <= 10^5
     * 
     * Task: Find length of the string after performing t transformations. 
     *
     * Observations: 
     * #1. Except for b, every character depends on the previous character. In case of a, it depends on z. 
     *  => b depends on occurrencesof a and z. 
     * #2. For b, the contributions comes from a and z. The 'a' is transformed to 'b' and 'z' is transformed to 'ab'.
     * #3. Length of the string depends on the frequency of each character. 
     * #4. Frequency of characters in each round of transformation depends on the resultant frequency of previous round of transformations. 
     * #5. For each round of transformation, assign previous frequency of z to a and assign sum of previous frequencies of a and z to b. 
     *     => For other characters, just copy the previous frequency of pervious character to the current character. 
     * #6. Find the summation of the frequency of all the characters. This will be the final length of the string after all the transformations are performed. 
     * #7. As the values are large, perform modulo operation with MOD = 1_000_000_000 + 7 for each arithemetic operation.  
     * 
     * Approach:
     * 1. Calculate frequency of each character in the string. Use integer array (frequency) of size 26 as only lowercase English letters. 
     * 2. Perform all the transformations as follows :
     *    => Create another integer array transformFrequency, to store the frequencies of the characters after transformation. 
     *    => Assign previous frequency of z to a that is  frequency[25] to transformFrequency[0].
     *    => For transformFrequency[1] = (frequency[0] + frequency[25]) % MOD. As frequency of b depends on summation of previous frequency of a and z. 
     *    => For all the remaining characters i.e. 'c' to 'z', copy the previous frequency of the previous character. 
     *    => Assign nextFrequency to the frequency, as the current nextFrequency will be previous frequency for next round of transformation. 
     * 3. After all the transformations, perform summation of frequencies of all characters, to find the length of the final string.            
     * 
     * Time Complexity: O(N + t)
     *      - To count the frequency of each character : O(N)
     *      - To perform transformation : O(26 * t) => O(t).
     *        -- Number of transformation = t. 
     *        -- For each transformation loop from 2 to 25 and 2 additional assignment for a and b => 26
     *      - To perform summation of all the frequencies : O(26).
     *      - Final Complexity : O(N + 26*t + 26) => O(N + t).
     *          
     * Space Complexity: O(1)
     *      - To store frquency of all characters array of type interger size 26 is used : O(26)
     *      - To store transformation frequencey another integer array of size 26 is used : O(26)
     *      - Final Complexity : O(52) => O(1)
     *      - As there is no additional space proportional to the input size is used. It can be considered as constant. 
     */

    @Test
    public void test1() {
        assertEquals(7, lengthAfterTransformations("abcyy", 2));
    }

    @Test
    public void test2() {
        assertEquals(5, lengthAfterTransformations("azbk", 1));
    }

    @Test
    public void test3() {
        assertEquals(79033769, lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
    }

    public int lengthAfterTransformations(String s, int t) {
        int MOD = (int) 1e9 + 7;
        int[] frequency = new int[26];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        while (t-- > 0) {
            int[] nextFrequency = new int[26];
            nextFrequency[0] = frequency[25]; // 'a' gets count of previous 'z'
            nextFrequency[1] = (frequency[0] + frequency[25]) % MOD;  // 'b' = previous 'a' + 'z'
            for (int i = 2; i < 26; i++) {
                nextFrequency[i] = frequency[i - 1]; // 'c' to 'z' = previous char
            }
            frequency = nextFrequency;
        }

        int newLength = 0;
        for (int freq : frequency) {
            newLength = (newLength + freq) % MOD;
        }
        return newLength;
    }
}
