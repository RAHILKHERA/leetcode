import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_273_IntegertoEnglishWords {

    @Test
    public void test1() {
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", numberToWords(1234567));
    }

    private static Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(1, "One ");
        map.put(2, "Two ");
        map.put(3, "Three ");
        map.put(4, "Four ");
        map.put(5, "Five ");
        map.put(6, "Six ");
        map.put(7, "Seven ");
        map.put(8, "Eight ");
        map.put(9, "Nine ");
        map.put(10, "Ten ");
        map.put(11, "Eleven ");
        map.put(12, "Twelve ");
        map.put(13, "Thirteen ");
        map.put(14, "Fourteen ");
        map.put(15, "Fifteen ");
        map.put(16, "Sixteen ");
        map.put(17, "Seventeen ");
        map.put(18, "Eighteen ");
        map.put(19, "Nineteen ");
        map.put(20, "Twenty ");
        map.put(30, "Thirty ");
        map.put(40, "Forty ");
        map.put(50, "Fifty ");
        map.put(60, "Sixty ");
        map.put(70, "Seventy ");
        map.put(80, "Eighty ");
        map.put(90, "Ninety ");
        map.put(100, "Hundred ");
        map.put(1000, "Thousand ");
        map.put(1000000, "Million ");

    }

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        int[] digits = seperateDigits(num);

        StringBuilder builder = new StringBuilder();
        if (digits[10] > 0) {
            builder.append(map.get(digits[10])).append("Billion ");
        }

        if (digits[9] > 0 || digits[8] > 0 || digits[7] > 0) {
            builder.append(threeCombo(9, digits)).append("Million ");
        }

        if (digits[6] > 0 || digits[5] > 0 || digits[4] > 0) {
            builder.append(threeCombo(6, digits)).append("Thousand ");
        }

        if (digits[3] > 0 || digits[2] > 0 || digits[1] > 0) {
            builder.append(threeCombo(3, digits));
        }

        return builder.toString().trim();
    }

    private String threeCombo(int index, int[] digits) {

        StringBuilder builder = new StringBuilder();

        if (digits[index] > 0) {
            builder.append(map.get(digits[index])).append(map.get(100));
        }
        index--;
        if (digits[index] > 0) {

            if (digits[index] == 1) {

                int num = 10 + digits[--index];
                builder.append(map.get(num));
            } else {
                builder.append(map.get(10 * digits[index]));
                if (digits[--index] > 0) {
                    builder.append(map.get(digits[index]));
                }
            }
        } else if (digits[--index] > 0) {
            builder.append(map.get(digits[index]));
        }

        return builder.toString();
    }

    private int[] seperateDigits(int num) {
        int[] digits = new int[11];
        int index = 1;

        while (num > 0) {
            digits[index++] = num % 10;
            num /= 10;
        }

        return digits;
    }
}
