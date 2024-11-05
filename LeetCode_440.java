import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeetCode_440 {

    @Test
    public void test1() {
        assertEquals(9, findKthNumber(100, 90));
    }

    public int findKthNumber(int n, int k) {

        List<Long> result = new ArrayList<>();
        long currentNumber = 1;
        while (result.size() != k) {

            if (currentNumber <= n) {
                result.add(currentNumber);
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber > n) {
                    currentNumber /= 10;
                }
                currentNumber++;
            }
        }

        long ans = result.get(result.size() - 1);

        return (int) ans;

    }
}
