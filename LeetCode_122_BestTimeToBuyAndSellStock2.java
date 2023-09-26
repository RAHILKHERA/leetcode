import static org.junit.Assert.assertEquals;

public class LeetCode_122_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        
        assertEquals(7, new Solution_LeetCode_122_BestTimeToBuyAndSellStock2().maxProfit(new int [] {7,1,5,3,6,4}));
        assertEquals(4, new Solution_LeetCode_122_BestTimeToBuyAndSellStock2().maxProfit(new int [] {1,2,3,4,5}));
        assertEquals(0, new Solution_LeetCode_122_BestTimeToBuyAndSellStock2().maxProfit(new int [] {7,6,4,3,1}));
        
    }
}

class Solution_LeetCode_122_BestTimeToBuyAndSellStock2 {
    public int maxProfit(int [] prices) {

        int profit = 0;  
        int i = 0;      
        for (int j = i+1; j < prices.length; j++) {
            int currentProfit = prices[j] - prices[i];
            if (currentProfit > 0) {
                profit +=currentProfit;
                
            } 
            i = j;
        }
        return profit;
    }
}