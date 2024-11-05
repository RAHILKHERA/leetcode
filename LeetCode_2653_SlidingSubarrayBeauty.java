import static org.junit.Assert.assertArrayEquals;

import java.util.PriorityQueue;

import org.junit.Test;

public class LeetCode_2653_SlidingSubarrayBeauty {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { -1, -2, -2 }, getSubarrayBeauty(new int[] { 1, -1, -3, -2, 3 }, 3, 2));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { -1, -2, -3, -4 }, getSubarrayBeauty(new int[] { -1, -2, -3, -4, -5 }, 2, 2));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[] { -3, 0, -3, -3, -3 }, getSubarrayBeauty(new int[] { -3, 1, 2, -3, 0, -3 }, 2, 1));
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int left = 0;
        int right = 0;
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;
        int countNegatives = 0;
        while (right < n) {

            if (nums[right] < 0)
                countNegatives++;

            if ((right - left + 1 > k) && (nums[left++] < 0)) {
                countNegatives--;
            }

            if (right - left + 1 == k) {

                result[index++] = countNegatives >= x ? getXthSmallest(nums, left, right, x) : 0;

            }

            right++;
        }

        return result;

    }

    private int getXthSmallest(int[] nums, int left, int right, int x) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = left; i <= right; i++) {
            queue.offer(nums[i]);
            if (queue.size() > x) {
                queue.poll();
            }
        }

        return queue.poll();
    }
}
