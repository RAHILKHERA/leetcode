import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class LeetCode_1475_FinalPricesWithASpecialDiscountInAShop {

    @Test
    public void test() {

        assertArrayEquals(new int[] { 4, 2, 4, 2, 3 }, finalPrices(new int[] { 8, 4, 6, 2, 3 }));

    }

    @Test
    public void test2() {

        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, finalPrices(new int[] { 1, 2, 3, 4, 5 }));

    }

    @Test
    public void test3() {

        assertArrayEquals(new int[] { 9, 0, 1, 6 }, finalPrices(new int[] { 10, 1, 1, 6 }));

    }

    public int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] discount = new int[prices.length];
        Arrays.fill(discount, -1);
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                discount[stack.pop()] = i;
            }

            stack.push(i);
        }

        for (int i = 0; i < prices.length; i++) {

            if (discount[i] != -1) {
                result[i] = prices[i] - prices[discount[i]];
            } else {
                result[i] = prices[i];
            }
        }

        return result;
    }
}
