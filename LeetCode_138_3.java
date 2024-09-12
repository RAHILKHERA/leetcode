import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_138_3 {

    @Test
    public void test1() {
        assertEquals(27, countGoodIntegers(3, 5));
    }

    public long countGoodIntegers(int n, int k) {

        long result = 0;
        long x = (long) Math.pow(10, (double) n - 1);
        long smallest = 0;
        long largest = (long) Math.pow(10, n);
        if (x % k == 0) {
            smallest = x;
        } else {
            smallest = x + (k - (x % k));
        }

        while (smallest < largest) {

            if (isPalindrome(Long.toString(smallest))) {
                result++;
            }

            smallest += k;
        }

        return result;
    }

    private boolean isPalindrome(String num) {

        int[] count = new int[10];

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            count[ch - '0']++;
        }

        boolean foundOdd = false;

        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {

                if (foundOdd) {
                    return false;
                } else {
                    foundOdd = true;
                }
            }
        }

        return true;
    }
}
