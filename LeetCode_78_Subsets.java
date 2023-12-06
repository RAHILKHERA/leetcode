import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_Subsets {
    
    public static void main(String[] args) {
        new Solution_LeetCode_78_Subsets().subsets(new int[] {1,2,3});
    }
    
}
class Solution_LeetCode_78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
    
        List<List<Integer>>  allSubSets = new ArrayList<>();
        
        for (int i = 1; i <= nums.length; i++ ) {
            findSubsets(nums, i, 0, allSubSets, new ArrayList<>());
        }

        allSubSets.add(new ArrayList<>());   
        return allSubSets;        
    }

    private void findSubsets(int [] nums, int k, int start, List<List<Integer>> allSubsets, List<Integer> currentSubset) {

        if (currentSubset.size() == k) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            findSubsets(nums, k,  i+1, allSubsets, currentSubset);
            currentSubset.remove(currentSubset.size() - 1);
        }

    }    

}
