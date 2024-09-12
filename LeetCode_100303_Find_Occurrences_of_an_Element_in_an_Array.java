import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_100303_Find_Occurrences_of_an_Element_in_an_Array {

    @Test
    public void test1() {

        assertArrayEquals(new int[] { 0, -1, 2, -1 },
                occurrencesOfElement(new int[] { 1, 3, 1, 7 }, new int[] { 1, 3, 2, 4 }, 1));

    }

    @Test
    public void test2() {

        assertArrayEquals(new int[] { -1 },
                occurrencesOfElement(new int[] { 1, 2, 3 }, new int[] { 10 }, 5));

    }

    @Test
    public void test3() {

        assertArrayEquals(new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1 },
                occurrencesOfElement(new int[] { 1, 4, 3, 3, 6, 4, 8, 3, 10 }, new int[] { 1, 2, 1, 1, 1, 1, 2, 2, 1,
                        1 }, 7));

    }

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        int[] results = new int[queries.length];
        List<Integer> countIndex = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                countIndex.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > countIndex.size()) {
                results[i] = -1;
            } else {
                results[i] = countIndex.get(queries[i] - 1);
            }
        }

        return results;
    }
}
