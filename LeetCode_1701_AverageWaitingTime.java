public class LeetCode_1701_AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {

        long endTime = 0;
        long totalTime = 0;

        for (int[] customer : customers) {
            endTime = endTime < customer[0] ? customer[0] : endTime + customer[1];
            totalTime += endTime - customer[0];
        }

        return (double) totalTime / (double) customers.length;
    }
}
