import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LeetCode_1636_SortArraybyIncreasingFrequency {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 3, 1, 1, 2, 2, 2 }, frequencySort(new int[] { 1, 1, 2, 2, 2, 3 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 1, 3, 3, 2, 2 }, frequencySort(new int[] { 2, 3, 1, 3, 2 }));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] { 5, -1, 4, 4, -6, -6, 1, 1, 1 }, frequencySort(new int[] { -1, 1, -6, 4, 5, -6, 1,
                4, 1 }));
    }

    public int[] frequencySort(int[] nums) {

        int[] count = new int[201];

        for (int num : nums) {
            count[num + 100]++;
        }

        int index = 0;
        int result[] = new int[nums.length];
        int freq = 1;
        while (index < nums.length) {

            for (int i = 200; i >= 0; i--) {
                if (freq == count[i]) {

                    for (int j = 0; j < count[i]; j++) {
                        result[index] = i - 100;
                        index++;

                        if (index == nums.length) {
                            break;
                        }
                    }
                }

                if (index == nums.length) {
                    break;
                }
            }

            freq++;

        }

        return result;
    }
}
