import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_228_SummaryRanges {

    @Test
    public void test1() {
        System.out.println(summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
    }

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        List<List<Integer>> ranges = new ArrayList<>();
        List<Integer> range = new ArrayList<>();
        range.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1] + 1) {
                ranges.add(new ArrayList<>(range));
                range = new ArrayList<>();
            }
            range.add(nums[i]);
        }

        ranges.add(range);

        for (List<Integer> finalRange : ranges) {

            if (finalRange.size() == 1) {
                result.add(Integer.toString(finalRange.get(0)));
            } else {
                result.add(Integer.toString(finalRange.get(0)) + "->"
                        + Integer.toString(finalRange.get(finalRange.size() - 1)));
            }
        }

        return result;
    }
}
