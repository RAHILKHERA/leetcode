import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Thought Process :
 * 
 * Area of the Reactangle = width * height;
 * 
 * Step 1 : First think of finding the largest rectangle in 1D array that is one
 * single row. In this height will be 1, to find the width of a rectangle
 * (sub-array), think in following manner.
 * From the given position 'i', how much we can extend in left direction and
 * right direction. We can extend to left/right if the number in that position
 * is larger than or equal to current number. (point 1)
 *
 * Step 2 : Now, extend the thinking process of Step1 for next row. Consider
 * this way, '1' represents the block of height 1 and '0' represents absence of
 * block. An absence of block will not create a new rectangle nor will extend an
 * existing one. In the 2nd case, i.e. of '1', the vertical rectangle or column
 * or height of the rectangle
 * will be extended. Hence add 1 to the previous height of the block if current
 * block height is 1 else set the height to 0. At this point we have height, but
 * still we need the width to calculate the area.
 * 
 * Step 3: Width Calculation, At a given position how many blocks can be
 * extended in left and right direction. It can be extended in any direction if
 * the block on left or right has height greater than equal to the height of
 * current position. That is we need the index on left and right side with
 * height lower than the current position. Use monotonic increaseing stack for
 * this. Width = right_index - left_index -1;
 * 
 * Topics :
 * 
 * Dynamic Programming, Height is precomputed in stored for calculation of the
 * area.
 * Monotonioc Stack, To calculate the index next smallest right(NSR) and next
 * smallest left(NSL).
 * 
 * Also solve LeetCode 84, It is related to this.
 * 
 * !Important.
 * 
 */

public class LeetCode_85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {

            for (int i = 0; i < row.length; i++) {
                heights[i] = row[i] == '0' ? 0 : heights[i] + 1;
            }

            maxArea = Math.max(maxArea, calculateLargestArea(heights));
        }

        return maxArea;
    }

    private int calculateLargestArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? heights.length : stack.peek();

            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max((right[i] - left[i] - 1) * heights[i], maxArea);
        }

        return maxArea;
    }
}
