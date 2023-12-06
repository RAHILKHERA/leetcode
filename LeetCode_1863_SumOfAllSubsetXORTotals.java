import java.util.ArrayList;
import java.util.List;

public class LeetCode_1863_SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        new Solution_LeetCode_1863_SumOfAllSubsetXORTotals().subsetXORSum(new int[] {1,3});
    }
}

class Solution_LeetCode_1863_SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
         
        int n = nums.length, sum = 0;

        for (int k = 1; k <= n; k++) {
            sum = back(n, k, nums, 0, sum, new ArrayList<>());
        }

        return sum;
    }

    private int back(int n, int k, int [] nums,  int start, int sum, List<Integer> currentCombi) {

        if (currentCombi.size() == k) {

            int xor = 0;
            for (int x : currentCombi) {
                xor ^= x;
            }
            sum += xor; 
            return sum;
        }

        for (int i = start; i < n; i++) {

            currentCombi.add(nums[i]);
            sum = back(n, k, nums,  i+1, sum, currentCombi);
            currentCombi.remove(currentCombi.size() - 1);
        }

        return sum;
    }
}
