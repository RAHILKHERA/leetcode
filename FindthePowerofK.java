import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class FindthePowerofK {

    @Test
    public void test1() {
        assertArrayEquals(
                new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 292, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                        142, -1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1 },
                resultsArray(new int[] { 3, 22, 22, 7, 14, 11, 21, 3, 8, 5, 4, 286, 287, 288, 289, 290, 291, 292, 21, 9,
                        7, 11, 136, 137, 138, 139, 140, 141, 142, 11, 21, 13, 14, 15, 16, 17, 18, 19, 12, 13, 14, 15,
                        16, 1, 6 }, 7));
    }

    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Arrays.fill(result, -1);
        Stack stack = new Stack(n);
        int index = 0;
        for (int i = 0; i < n - k + 1; i++) {

            if (stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                stack.push(nums[i]);
                if (stack.getSize() >= k) {
                    result[index++] = nums[i];
                }
            } else {
                stack.clear();
                stack.push(nums[i]);
                result[index++] = -1;
            }
        }

        return result;

    }

    class Stack {

        int top;
        int[] nums;
        int capacity;
        int size;

        Stack(int n) {
            top = -1;
            nums = new int[n];
            size = 0;
            capacity = n;
        }

        public void push(int val) {
            nums[++top] = val;
            size++;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void clear() {
            nums = new int[capacity];
            top = -1;
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public int peek() {
            return nums[top];
        }
    }
}
