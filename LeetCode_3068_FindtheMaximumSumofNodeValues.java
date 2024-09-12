public class LeetCode_3068_FindtheMaximumSumofNodeValues {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {

        // Store final sum;
        long sum = 0;
        /**
         * Objective need to maximize the sum of all the elements of nums.
         * 
         * On performing an operation of XOR, value of the original number can either be
         * increase or decreased.
         * 
         * As we want to maximize the sum, we will only consider the value obtain after
         * the operation if it has increased.
         * 
         * There is a constraint that operation should be performed on edge. Hence the
         * number of the operations should always be even.
         * 
         * In case of odd number of operations which have increased the value. We will
         * need to select one element whose value has decreased after applying the
         * operation, this value has to be minimum in all the decreasing value
         * operations. This will be stored in minLoss.
         * 
         * To check whether the number of operations perfomed is odd or even we will
         * maintain a boolean flag `count`
         * 
         */
        long minLoss = Integer.MAX_VALUE;
        boolean count = true;

        for (long num : nums) {

            if ((num ^ k) > num) {
                sum += num ^ k;
                count = !count;
            } else {
                sum += num;
            }

            minLoss = Math.min(minLoss, Math.abs(num - (num ^ k)));
        }

        if (!count) {
            sum -= minLoss;
        }

        return sum;
    }
}
