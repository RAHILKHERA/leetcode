import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1052_GrumpyBookStoreOwner {

    @Test
    public void test1() {
        assertEquals(0, 0);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int max = 0, left = 0, right = 0, current = 0, satisfied = 0;

        while (right < customers.length) {

            if (right - left + 1 > minutes) {
                if (grumpy[left] == 1) {
                    current -= customers[left];
                }
                left++;
            } else if (grumpy[right] == 1) {
                current += customers[right];
            }

            if (grumpy[right] == 0) {
                satisfied += customers[right];
            }

            max = Math.max(max, current);

            right++;
        }

        return max + satisfied;
    }

}
