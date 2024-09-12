public class LeetCode_860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {

        int count5 = 0;
        int count10 = 0;

        for (int bill : bills) {

            switch (bill) {
                case 5:
                    count5++;
                    break;
                case 10:
                    if (count5 == 0) {
                        return false;
                    }
                    count5--;
                    count10++;
                    break;
                case 20:
                    if (count10 > 0 && count5 > 0) {
                        count10--;
                        count5--;
                    } else if (count5 > 2) {
                        count5 -= 3;
                    }
            }

        }

        return true;

    }
}
