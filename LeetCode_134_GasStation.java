
public class LeetCode_134_GasStation {
    public static void main(String[] args) {
        // System.out.println(new
        // Solution_LeetCode_134_GasStation().canCompleteCircuit(new int[] {1,2,3,4,5},
        // new int []{3,4,5,1,2}));
        System.out.println(new Solution_LeetCode_134_GasStation().canCompleteCircuit(new int[] { 3, 1, 1 },

                new int[] { 1, 2, 2 }));
    }
}

class Solution_LeetCode_134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int remainingGas = 0;
        int totalGas = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            remainingGas += diff;
            totalGas += diff;

            if (remainingGas < 0) {
                remainingGas = 0;
                start = i + 1;
            }
        }

        return totalGas >= 0 ? start : -1;
    }

}
