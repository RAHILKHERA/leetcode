public class LeetCode_121_Stocks {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(new Solution_LeetCode_121_Stocks().maxProfit(prices));
    }
}

class Solution_LeetCode_121_Stocks {
    public int maxProfit(int[] prices) {
       
        int profit = 0;        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j<prices.length; j++) {
                int currentProfit = prices[j] - prices[i];
                profit = profit > currentProfit ? profit : currentProfit;
            }
        }

        

        return profit;
    }
}
