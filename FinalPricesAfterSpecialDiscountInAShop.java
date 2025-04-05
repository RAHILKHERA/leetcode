import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesAfterSpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }

        return prices;
    }
}