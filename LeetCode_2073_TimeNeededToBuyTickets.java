public class LeetCode_2073_TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0, index = 0;

        while (tickets[k] != 0) {

            if (tickets[index] > 0) {
                tickets[index]--;
                time++;
            }
            index++;

            if (index == tickets.length) {
                index = 0;
            }
        }

        return time;
    }
}
