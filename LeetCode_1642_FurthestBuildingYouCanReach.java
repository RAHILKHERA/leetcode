import java.util.PriorityQueue;

public class LeetCode_1642_FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        /**
         * Maintaining max heap or max priortiy queue to keep the track of the largest
         * jump performed till the given point.
         * As it is max heap, we have pass the comprator with b,a.
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < heights.length - 1; i++) {

            int diff = heights[i + 1] - heights[i];

            /**
             * Don't need to use either of the resources for jumping to same or lower level
             * building.
             */
            if (diff <= 0) {
                continue;
            }

            bricks -= diff;
            queue.offer(diff);

            /**
             * If bricks are over, check if there was a large jump which can be replaced
             * with a ladder, if possible.
             * In that case, we will regain the bricks used in that jump.
             */
            if (bricks < 0) {
                if (ladders == 0) {
                    /**
                     * Both bricks and ladders are finished and we have to jump to higher level
                     * building.
                     * So returning from here.
                     */
                    return i;
                }
                ladders--;
                if (!queue.isEmpty()) {
                    bricks += queue.poll();
                }
            }

        }

        return heights.length - 1;
    }
}
