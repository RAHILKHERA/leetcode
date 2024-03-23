import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_56_MergeIntervals {
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int idx = 0, j = idx;

        while (idx < intervals.length) {

            while (j < intervals.length && intervals[j][0] <= intervals[idx][1]) {
                intervals[idx][0] = Math.min(intervals[idx][0], intervals[j][0]);
                intervals[idx][1] = Math.max(intervals[idx][1], intervals[j][1]);
                j++;
            }

          
            result.add(intervals[idx]);
            idx = j;
        }

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
