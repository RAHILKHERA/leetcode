import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_670_MaximumSwap {

    @Test
    public void test1() {
        assertEquals(98863, maximumSwap(98368));
    }

    public int maximumSwap(int num) {
        int n = (int) Math.log10(num) + 1;
        int[] digits = new int[n];
        int[] max = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;

        }

        max[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {

            if (digits[max[i + 1]] > digits[i]) {
                max[i] = max[i + 1];
            } else if (digits[max[i + 1]] == digits[i]) {
                max[i] = max[i + 1];
            } else {
                max[i] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (digits[i] != digits[max[i]]) {
                int temp = digits[max[i]];
                digits[max[i]] = digits[i];
                digits[i] = temp;
                break;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result * 10 + digits[i];
        }

        return result;
    }
}
