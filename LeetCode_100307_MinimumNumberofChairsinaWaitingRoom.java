public class LeetCode_100307_MinimumNumberofChairsinaWaitingRoom {

    public int minimumChairs(String s) {
        int total = 0, available = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'E') {

                if (available == 0) {
                    total++;
                } else {
                    available--;
                }
            } else {
                available++;
            }

        }

        return total;
    }
}
