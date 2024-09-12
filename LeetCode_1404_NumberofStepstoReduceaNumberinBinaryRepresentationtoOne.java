import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1404_NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {

    @Test
    public void test1() {
        assertEquals(6, numSteps("1101"));
    }

    public int numSteps(String s) {

        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            steps++;
            if ((s.charAt(i) - '0' + carry) % 2 == 1) {
                steps++;
                carry = 1;
            }
        }

        return steps + carry;
    }

}