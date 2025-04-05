import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MinimumIndexofValidSplit {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        assertEquals(0, minimumIndex(list));
    }

    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        int candidate = 0;
        int count = 1;
        for (int num : nums) {
            if (candidate != num) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                candidate = num;
                count = 1;
            }
            map.merge(num, 1, Integer::sum);
        }

        int totalCount = map.get(candidate);
        count = 0;
        int idx = 0;
        while (idx < n) {

            if (nums.get(idx) == candidate) {
                count++;
                int leftSideSize = idx + 1;
                int rightSideSize = n - leftSideSize;
                if (count > leftSideSize / 2 && ((totalCount - count) > (rightSideSize / 2))) {
                    return idx;
                }
            }
            idx++;
        }
        return -1;
    }
}
