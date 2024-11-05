import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.*;;

public class LeetCode_417_Q3 {

    @Test
    public void test1() {
        assertEquals(3, countOfSubstrings("ieaouqqieaouqq", 1));
    }

    public boolean isVowel(char ch) {
        return (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u');
    }

    public long countOfSubstrings(String word, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        long ans = 0;

        int n = word.length();
        int[] pre = new int[n];

        // Initialize prefix sum for consonants
        if (!isVowel(word.charAt(0))) {
            pre[0] = 1;
        }

        // Fill the prefix array with counts of consonants
        for (int i = 1; i < n; i++) {
            if (!isVowel(word.charAt(i))) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = pre[i - 1];
            }
        }

        int i = 0; // Left pointer
        int j = 0; // Right pointer
        int cntk = 0; // Count of consonants

        // Main logic to count valid substrings
        while (j < n) {
            // Increment count of consonants and vowels in the map
            if (isVowel(word.charAt(j))) {
                mp.put(word.charAt(j), mp.getOrDefault(word.charAt(j), 0) + 1);
            } else {
                cntk++;
            }

            // Shrink the window if consonant count exceeds k
            while (cntk > k) {
                if (isVowel(word.charAt(i))) {
                    mp.put(word.charAt(i), mp.get(word.charAt(i)) - 1);
                    if (mp.get(word.charAt(i)) == 0) {
                        mp.remove(word.charAt(i));
                    }
                } else {
                    cntk--;
                }
                i++;
            }

            // Check if we have all vowels and exactly k consonants
            while (mp.size() >= 5 && cntk == k) {
                int ub = upperBound(pre, pre[j]) - 1; // Find the upper bound
                ans += (long) (ub - j);
                if (isVowel(word.charAt(i))) {
                    mp.put(word.charAt(i), mp.get(word.charAt(i)) - 1);
                    if (mp.get(word.charAt(i)) == 0) {
                        mp.remove(word.charAt(i));
                    }
                } else {
                    cntk--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    // Helper function to find upper bound index
    public int upperBound(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
