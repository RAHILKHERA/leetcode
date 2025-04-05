import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class LeetCodeFindAdjacent {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(1);

        assertTrue(hasIncreasingSubarrays(list, 3));
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(-19);
        list.add(-8);
        list.add(-16);

        assertFalse(hasIncreasingSubarrays(list, 2));
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        list.add(-15);
        list.add(19);

        assertTrue(hasIncreasingSubarrays(list, 1));
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            boolean increasing = true;
            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    increasing = false;
                    break;
                }
            }

            if (increasing) {
                if (set.contains(i - k))
                    return true;
                set.add(i);
            }

        }

        return false;
    }
}