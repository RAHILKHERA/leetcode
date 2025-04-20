package Week17_2025;

/**
 * LeetCode Problem: 781 - Rabbits in Forest
 * Problem Link:
 * https://leetcode.com/problems/rabbits-in-forest/description/?envType=daily-question&envId=2025-04-20
 *
 * Definition:
 * In a forest, some rabbits were asked, "How many rabbits have the same color as you?".
 * Each rabbit's answer is given as an element in an int[] array.
 *
 * Task:
 * Find the minimum number of rabbits that could be present in the forest.
 *
 * Observations:
 * #1. When a rabbit answers x, it means there are (x + 1) rabbits of the same color (including itself).
 * #2. Rabbits can be grouped based on their answers, assuming each group has size (x + 1).
 * #3. The size of each group is determined by the rabbit's answer.
 * #4. We maintain a map of group size → current number of rabbits seen in that group.
 * #5. If two rabbits give the same answer, they can be added to the same group if that group isn't full.
 *     For example:
 *     - First rabbit answers 2 → group size = 3 → add to map as 3 → 1.
 *     - Second rabbit answers 2 → update map to 3 → 2.
 *     - Third rabbit answers 2 → map becomes 3 → 3 (group is now full).
 *     Before resetting the group, add group size to final count, then reset group to allow another group of same size.
 *
 * #6. Not all rabbits may have answered. So at the end, any partially filled groups should also be counted.
 *     For these, add the full group size (because we must assume the worst case to ensure correctness).
 *
 * #7. Since the constraints are small and answers are non-negative integers, instead of using a HashMap,
 *     we can use an array where the index represents the group size, and the value is the number of rabbits seen in that group.
 *
 * Approach:
 * 1. Find the maximum value in the answers array to size the array-based map.
 * 2. Iterate through each answer:
 *    a. Calculate group size = answer + 1.
 *    b. Increment the count of rabbits seen for that group size.
 *    c. If the group is full, add group size to result and reset its count.
 * 3. After processing all answers, loop through the array to add sizes of any remaining partially filled groups.
 *
 * Time Complexity: O(n + max)
 *   - O(n) to find the max
 *   - O(n) to process the answers
 *   - O(max) to finalize remaining groups
 *   => Final: O(n + max)
 *
 * Space Complexity: O(max)
 *   - Using an array of size (max + 1) for group tracking.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeetCode_781_RabbitsInForest {

    @Test
    public void test1() {
        assertEquals(5, numRabbits(new int[] { 1, 1, 2 }));
    }

    @Test
    public void test2() {
        assertEquals(11, numRabbits(new int[] { 10, 10, 10 }));
    }

    @Test
    public void test3() {
        assertEquals(6, numRabbits(new int[] { 0, 0, 1, 1, 1 }));
    }

    @Test
    public void test4() {
        assertEquals(13, numRabbits(new int[] { 2, 1, 2, 2, 2, 2, 2, 2, 1, 1 }));
    }

    @Test
    public void testEmpty() {
        assertEquals(0, numRabbits(new int[] {}));
    }

    @Test
    public void testAllZeros() {
        assertEquals(4, numRabbits(new int[] { 0, 0, 0, 0 }));
    }

    public int numRabbits(int[] answers) {

        int count = 0;
        int maxGroupSize = -1;
        for (int answer : answers) {
            maxGroupSize = Math.max(maxGroupSize, answer + 1);
        }

        // group size vs number of rabbits in the group.
        int[] groups = new int[maxGroupSize + 1];

        for (int answer : answers) {
            int groupSize = answer + 1;
            groups[groupSize]++;
            // Group is full.
            if (groups[groupSize] == groupSize) {
                count += groupSize;
                // Reset the group count to allow a new group of the same size to form.
                groups[groupSize] = 0;
            }
        }

        // Find incomplete groups.
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] > 0) {
                count += i;
            }
        }

        return count;
    }
}