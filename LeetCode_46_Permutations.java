import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class LeetCode_46_Permutations {

    @Test
    public void test1() {
        List<List<Integer>> expectedList = new ArrayList<>();

        expectedList.add(Arrays.asList(1, 2, 3));
        expectedList.add(Arrays.asList(1, 3, 2));
        expectedList.add(Arrays.asList(2, 1, 3));
        expectedList.add(Arrays.asList(2, 3, 1));
        expectedList.add(Arrays.asList(3, 1, 2));
        expectedList.add(Arrays.asList(3, 2, 1));

        assertTrue(expectedList.containsAll(permute(new int[] { 1, 2, 3 })));

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] nums, Set<Integer> used, List<Integer> combination, List<List<Integer>> result) {

        if (combination.size() == nums.length) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                combination.add(nums[i]);
                backtracking(nums, used, combination, result);
                combination.remove(combination.size() - 1);
                used.remove(nums[i]);
            }
        }
    }
}
