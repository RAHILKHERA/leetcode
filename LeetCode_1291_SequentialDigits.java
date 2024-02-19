import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LeetCode_1291_SequentialDigits {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(234);
        assertEquals(list, sequentialDigits(100, 300));
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1234);
        list.add(2345);
        list.add(3456);
        list.add(4567);
        list.add(5678);
        list.add(6789);
        list.add(12345);
        assertEquals(list, sequentialDigits(1000, 13000));
    }

    @Test
    public void test3() {
        assertEquals(Arrays.asList(67, 78, 89, 123), sequentialDigits(58, 155));
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        assertEquals(list, sequentialDigits(10, 10));
    }

    @Test
    public void test5() {
        assertEquals(Arrays.asList(12), sequentialDigits(12, 12));
    }

    @Test
    public void test6() {
        assertEquals(Arrays.asList(12), sequentialDigits(12, 15));
    }

    @Test
    public void test7() {
        assertEquals(Arrays.asList(12345, 23456), sequentialDigits(8511, 23553));
    }

    @Test
    public void test8() {
        assertEquals(Arrays.asList(), sequentialDigits(178546104, 812704742));
    }

    @Test
    public void test9() {
        assertEquals(Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456,
                4567, 5678,
                6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789,
                12345678, 23456789, 123456789), sequentialDigits(10, 1000000000));
    }

    private int digitCounts = 0;
    private int digitCountsHigh = 0;

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();

        digitCounts = countDigits(low);
        digitCountsHigh = countDigits(high);
        int firstDigit = (int) low / (int) Math.pow(10, digitCounts - 1);

        int sequentialNumber = generateFirstNumber(firstDigit);

        if (low == high) {
            if (sequentialNumber == low) {
                result.add(sequentialNumber);
            }
            return result;
        }

        if (sequentialNumber >= low) {
            result.add(sequentialNumber);
        }

        while (sequentialNumber <= high) {
            int interimNumber = sequentialNumber % (int) Math.pow(10, digitCounts - 1);
            int lastDigit = interimNumber % 10;
            if (lastDigit != 9) {
                sequentialNumber = interimNumber * 10 + lastDigit + 1;
            } else {
                digitCounts++;

                if (digitCounts > digitCountsHigh) {
                    break;
                }

                sequentialNumber = generateFirstNumber(1);

                if (result.size() != 0 && sequentialNumber == result.get(result.size() - 1)) {
                    break;
                }

            }

            if (sequentialNumber <= high && sequentialNumber >= low) {
                result.add(sequentialNumber);
            }

        }

        return result;
    }

    private int generateFirstNumber(int firstDigit) {
        int sum = 0;
        boolean regenerateFromOne = false;
        for (int i = 0; i < digitCounts; i++) {

            sum = sum * 10 + firstDigit;

            firstDigit++;

            if (firstDigit == 10 && i < digitCounts - 1) {
                digitCounts++;
                regenerateFromOne = true;
                break;
            }
        }

        if (regenerateFromOne && digitCounts <= digitCountsHigh) {
            sum = generateFirstNumber(1);
        }

        return sum;
    }

    private int countDigits(int low) {

        int count = 0;

        while (low > 0) {
            count++;
            low /= 10;
        }

        return count;
    }
}