import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_621_TaskScheduler {

    @Test
    public void test1() {
        assertEquals(8, leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
    }

    @Test
    public void test2() {
        assertEquals(6, leastInterval(new char[] { 'A', 'C', 'A', 'B', 'D', 'B' }, 1));
    }

    @Test
    public void test3() {
        assertEquals(10, leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 3));
    }

    @Test
    public void test4() {
        assertEquals(12, leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 1));
    }

    public int leastInterval(char[] tasks, int n) {

        // Counts of each task where index 0 represents 'A', 1 represents 'B', and so
        // on.
        int[] taskCounts = new int[26];
        // Maximum frequency among the tasks
        int maxFrequency = 0;

        // Loop over the tasks to count them and find the task with maximum frequency.
        for (char task : tasks) {
            // Convert the task from char type to an index for our count array
            int index = task - 'A';
            // Increment the count for this task
            taskCounts[index]++;
            // Update the maximum frequency
            maxFrequency = Math.max(maxFrequency, taskCounts[index]);
        }

        // Count how many tasks have the maximum frequency
        int maxFrequencyTasks = 0;
        for (int count : taskCounts) {
            if (count == maxFrequency) {
                maxFrequencyTasks++;
            }
        }

        // Calculate the minimum length of the task schedule
        // Each block of tasks includes the cooldown period followed by the most
        // frequent task itself
        // Then, add the number of tasks with maximum frequency to cover the last one
        // without tailing idle time
        int minScheduleLength = Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxFrequencyTasks);

        return minScheduleLength;
    }
}
