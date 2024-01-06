import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_2610_ConvertAnArrayIntoA2DArrayWithConditions {

    public static void main(String[] args) {
        new LeetCode_2610_ConvertAnArrayIntoA2DArrayWithConditions().findMatrix(new int[] { 1, 2, 3, 4 });
    }

    public List<List<Integer>> findMatrix(int[] nums) {

        int count[] = new int[201];
        Arrays.fill(count, -1);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            max = count[nums[i]] > max ? count[nums[i]] : max;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 1; i < count.length; i++) {
            while (count[i] >= 0) {
                result.get(count[i]--).add(i);
            }
        }

        return result;
    }
}
