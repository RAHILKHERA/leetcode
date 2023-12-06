import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_39_CombinationSum {
    
    public static void main(String[] args) {
        new Solution_LeetCode_39_CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);    
    }
}

class Solution_LeetCode_39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combiSum(candidates, new ArrayList<>(), 0, target, result);
        return result;
    }

    // private void combiSum(int [] candidates, List<Integer> currentCombi, int sum, int target, List<List<Integer>> result) {

    //     if (sum == target) {
    //         result.add(new ArrayList<>(currentCombi));
    //         return;
    //     }

    //     for (int i = 0; i < candidates.length; i++) {

    //         sum += candidates[i];
    //         currentCombi.add(candidates[i]);

    //         if (sum > target) {
    //             sum -= candidates[i];
    //             currentCombi.remove(currentCombi.size() - 1);
    //             return;
    //         } else {
    //             combiSum(candidates, currentCombi, sum, target, result);
    //         }

    //         sum -= candidates[i];
    //         currentCombi.remove(currentCombi.size() - 1);
    //     }
    // }

    private void combiSum(int[] candidates, List<Integer> currentCombi, int start, int target, List<List<Integer>> result) {
    if (target == 0) {
        result.add(new ArrayList<>(currentCombi));
        return;
    }

    for (int i = start; i < candidates.length; i++) {
        int newTarget = target - candidates[i];

        if (newTarget < 0) {
            // Skip if the current candidate makes the target negative
            continue;
        }

        currentCombi.add(candidates[i]);
        combiSum(candidates, currentCombi, i, newTarget, result);
        currentCombi.remove(currentCombi.size() - 1);
    }
}

}
