import java.util.ArrayDeque;

public class LeetCode_977_SquaresOfaSortedArray {
    public int[] sortedSquares(int[] nums) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                stack.push(nums[i] * nums[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums[i] * nums[i]) {
                    nums[j] = stack.pop();
                    j++;
                }

                nums[j] = nums[i] * nums[i];
                j++;
            }
        }

        while (!stack.isEmpty()) {
            nums[j] = stack.pop();
            j++;
        }

        return nums;
    }
}
