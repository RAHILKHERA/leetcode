import static org.junit.Assert.assertArrayEquals;

import java.util.Stack;

import org.junit.Test;

public class LeetCode_739_DailyTemperatures {

    @Test
    public void test() {
        assertArrayEquals(new int[] { 1, 1, 4, 2, 1, 1, 0, 0 }, dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72,
                76, 73 }));
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 1, 1, 1, 0 }, dailyTemperatures(new int[] { 30, 40, 50, 60 }));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[] { 1, 1, 0 }, dailyTemperatures(new int[] { 30, 60, 90 }));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        return answer;
    }
}
