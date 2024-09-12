import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Monotonic Stack
 * !Important
 * Do it in conjuction with 85.
 */
public class LeetCode_84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];

        // Find the index of the block on left side whose height is strickly less than
        // current block.
        // As we need index of block with lesser height, we will remove all the blocks
        // having higher or equal height from the stack.

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Find the index of the block on right side whose height is strickly less than
        // current block.
        // As we need index of block with lesser height, we will remove all the blocks
        // having higher or equal height from the stack.

        for (int i = heights.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? heights.length : stack.peek();

            stack.push(i);
        }

        // Width of the rectangle is the numbr of elements between left and right,
        // exculsive of left and right i.e. right - left -1;

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }

        return maxArea;
    }
}
