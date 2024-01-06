public class LeetCode_2125_NumberOfLaserBeamsInABank {

    public int numberOfBeams(String[] bank) {

        int totalBeams = 0;
        int prevBeams = 0;
        for (int i = 0; i < bank.length; i++) {

            int totalDevicesInRow = 0;
            for (char ch : bank[i].toCharArray()) {
                if (ch == '1') {
                    totalDevicesInRow++;
                }
            }
            if (totalDevicesInRow > 0) {
                totalBeams += totalDevicesInRow * prevBeams;
                prevBeams = totalDevicesInRow;
            }

        }

        return totalBeams;
    }
}
