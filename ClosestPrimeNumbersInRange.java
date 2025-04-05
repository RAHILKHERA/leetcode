import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.junit.Test;

public class ClosestPrimeNumbersInRange {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 29, 31 }, closestPrimes(19, 31));
    }

    public int[] closestPrimes(int left, int right) {
        BitSet bitSet = getPrimes(right);

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (bitSet.get(i)) {
                primes.add(i);
            }
        }

        if (primes.size() < 2)
            return new int[] { -1, -1 };
        int[] ans = new int[2];
        int minDiff = Integer.MAX_VALUE;
        for (int i = primes.size() - 1; i > 0; i--) {
            int x = primes.get(i - 1);
            int y = primes.get(i);
            if ((y - x) <= minDiff) {
                ans[0] = x;
                ans[1] = y;
                minDiff = y - x;
            }
        }
        return ans;
    }

    private BitSet getPrimes(int upperLimit) {
        BitSet bitSet = new BitSet();
        bitSet.set(0, upperLimit + 1);
        for (int number = 2; number * number <= upperLimit; number++) {
            if (bitSet.get(number)) {
                for (int multiple = number * number; multiple <= upperLimit; multiple += number) {
                    bitSet.clear(multiple);
                }
            }
        }
        return bitSet;
    }
}
