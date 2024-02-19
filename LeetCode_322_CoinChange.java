import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_322_CoinChange {

    @Test
    public void test1() {
        assertEquals(3, coinChange(new int[] { 1, 2, 5 }, 11));
    }

    @Test
    public void test2() {
        assertEquals(-1, coinChange(new int[] { 2 }, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        if (amount == 0) {
            return 0;
        }

        return dfs(coins, amount, amount, 0, 0, 0, memo);
    }

    private int dfs(int[] coins, int amount, int remainingAmount, int unChanged, int totalCoins, int index,
            int[][] memo) {

        if (unChanged == coins.length) {
            return -1;
        }

        if (remainingAmount == 0) {
            return totalCoins;
        } else if (remainingAmount < 0) {
            return -1;
        } else if (index >= coins.length && remainingAmount > 0) {
            index = 0;
            unChanged = 0;
        }

        if (memo[index][remainingAmount] != -1) {
            return memo[index][remainingAmount];
        }

        int include = dfs(coins, amount, remainingAmount - coins[index], unChanged, totalCoins + 1, index + 1, memo);
        int exclude = dfs(coins, amount, remainingAmount, unChanged + 1, totalCoins, index + 1, memo);

        if (include == -1 && exclude == -1) {
            memo[index][remainingAmount] = -1;
        } else if (include == -1) {
            memo[index][remainingAmount] = exclude;
        } else if (exclude == -1) {
            memo[index][remainingAmount] = include;
        } else {
            memo[index][remainingAmount] = Math.min(include, exclude);
        }

        return memo[index][remainingAmount];
    }
}
