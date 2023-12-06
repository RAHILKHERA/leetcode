import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_Combinations {
    public static void main(String[] args) {
        new Solution_LeetCode_77_Combinations().combine(5, 3);
    }
}

class Solution_LeetCode_77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();

        back(n, k, 1, result, new ArrayList<>());

        return result;
    }

    private void back(int n, int k, int start, List<List<Integer>> result, List<Integer> currentCombi) {

        if (currentCombi.size() == k) {
            result.add(new ArrayList<>(currentCombi)); // Create a copy and add it to the result
            return;
        }

        for (int i = start; i <=n; i++) {

            currentCombi.add(i);

            back(n, k, i+1, result, currentCombi);

             currentCombi.remove(currentCombi.size() - 1);

        }
    }
}
