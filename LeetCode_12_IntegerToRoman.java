import java.util.HashMap;

public class LeetCode_12_IntegerToRoman {
    
}

class Soultion_LeetCode_12_IntegerToRoman {

    private static HashMap<Integer, String> rules = new HashMap <>();
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
 
    static {
        rules.put(1, "I");
        rules.put(4, "IV");
        rules.put(5, "V");
        rules.put(9, "IX");
        rules.put(10, "X");
        rules.put(40, "XL");
        rules.put(50, "L");
        rules.put(90, "XC");
        rules.put(100, "C");
        rules.put(400, "CD");
        rules.put(500, "D");
        rules.put(900, "CM");
        rules.put(1000, "M");

    }

    public String intToRoman(int num) {

        StringBuilder roman = new StringBuilder();
        int saveNum = num;
        if (rules.containsKey(num)) {
            return rules.get(num);
        } 

        for (int i = 0; i < values.length && num > 0; i++) {
            // repeat while the current symbol still fits into num
            while (values[i] <= num) {
              num -= values[i];
              roman.append(symbols[i]);
            }
          }

        String result = roman.toString();
        rules.put(saveNum, result);
        return result;
    }
}