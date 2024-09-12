import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_3147_TakingMaximumEnergyFromTheMystreDragon {

    @Test
    public void test1() {

        assertEquals(3, maximumEnergy(new int[] { 5, 2, -10, -5, 1 }, 3));
    }

    public int maximumEnergy(int[] energy, int k) {

        int n = energy.length;
        int dp[] = new int[n];
        int maximumEnergy = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (i + k < n) {
                dp[i] = dp[i + k] + energy[i];
            } else {
                dp[i] = energy[i];
            }
            maximumEnergy = dp[i] > maximumEnergy ? dp[i] : maximumEnergy;
        }
        return maximumEnergy;
    }
}
