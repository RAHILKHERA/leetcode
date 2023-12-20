public class LeetCode_2706_BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {

        int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int price : prices) {

            if (price < min) {
                min2 = min;
                min = price;
            } else if (price < min2) {
                min2 = price;
            }

        }

        if (money - min - min2 >= 0) {
            return money - min - min2;
        }
        return money;
    }
}
