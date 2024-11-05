import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class LeetCode_2463_MinimumTotalDistanceTraveled {

    @Test
    public void test1() {
        List<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);
        assertEquals(4, minimumTotalDistance(robot, new int[][] { { 2, 2 }, { 6, 2 } }));
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        // Step 1 : Sort robot and facotries as per the positions.
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        // Step 2 : Flatten the positions array.
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] fact : factory) {
            for (int i = 0; i < fact[1]; i++) {
                factoryPositions.add(fact[0]);
            }
        }

        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();

        // // Step 3: Memoization Intialization.
        // long[][] memo = new long[robotCount+1][factoryCount+1];
        // for (long[] row : memo) {
        // Arrays.fill(row, -1);
        // }

        // // Step4 : Call recursion.
        // return calculateMinDistance(0,0, robot, factoryPositions, memo);

        long[][] dp = new long[robotCount + 1][factoryCount + 1];
        for (int i = 0; i < robotCount; i++) {
            dp[i][factoryCount] = (long) 1e12; // No factories left
        }

        for (int i = robotCount - 1; i >= 0; i--) {
            for (int j = factoryCount - 1; j >= 0; j--) {
                long assign = Math.abs(robot.get(i) - factoryPositions.get(j)) + dp[i + 1][j + 1];
                long skip = dp[i][j + 1];
                dp[i][j] = Math.min(assign, skip);
            }
        }

        return dp[0][0];

    }

    private long calculateMinDistance(int robotIndex, int factoryIndex, List<Integer> robot,
            List<Integer> factoryPositions, long[][] memo) {

        if (robotIndex == robot.size()) {
            return 0;
        }

        if (factoryIndex == factoryPositions.size()) {
            return (long) 1e12;
        }

        if (memo[robotIndex][factoryIndex] != -1) {
            return memo[robotIndex][factoryIndex];

        }

        long assign = Math.abs(robot.get(robotIndex) - factoryPositions.get(factoryIndex))
                + calculateMinDistance(robotIndex + 1, factoryIndex + 1, robot, factoryPositions, memo);
        long skip = calculateMinDistance(robotIndex, factoryIndex + 1, robot, factoryPositions, memo);

        return memo[robotIndex][factoryIndex] = Math.min(assign, skip);
    }
}
