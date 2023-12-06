import java.util.HashMap;

public class LeetCode_2264_Largest3Same_DigitNumberInString {
    
}

class Solution_LeetCode_2264_Largest3Same_DigitNumberInString {
    
    private static HashMap<Integer, String> map;

    static {
        map = new HashMap<>(9);
        map.put(0, "000");
        map.put(1, "111");
        map.put(2, "222");
        map.put(3, "333");
        map.put(4, "444");
        map.put(5, "555");
        map.put(6, "666");
        map.put(7, "777");
        map.put(8, "888");
    }


    
    public String largestGoodInteger(String num) {
        
        int k = 2, max = -1;

        char chI = num.charAt(0);
        char chJ = num.charAt(1);
      

        while (k < num.length()) {
            
            char chK = num.charAt(k);

            if (chI == chJ && chJ == chK) {

                int number = Character.getNumericValue(chK);

                if (number == 9) {
                    return "999";
                } else if (max < number) {
                    max = number;
                }

            }
            chI = chJ;
            chJ = chK;
            k++;
            
        }

        if (max > -1) {
            return map.get(max);
        }

        return "";
    }
}