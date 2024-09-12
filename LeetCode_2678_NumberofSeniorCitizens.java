import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2678_NumberofSeniorCitizens {

    @Test
    public void test1() {
        assertEquals(2, countSeniors(new String[] { "7868190130M7522", "5303914400F9211", "9273338290F4010" }));
    }

    public int countSeniors(String[] details) {

        int count = 0;

        for (String detail : details) {

            int firstDigit = detail.charAt(11) - '0';
            if (firstDigit > 6) {
                count++;
            } else if (firstDigit == 6) {
                int secondDigit = detail.charAt(12) - '0';
                if (secondDigit > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
