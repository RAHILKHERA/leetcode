import java.util.HashMap;

public class LeetCode_13_RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new Solution_LeetCode_13_RomanToInteger().romanToInt("III"));
        System.out.println(new Solution_LeetCode_13_RomanToInteger().romanToInt("LVIII"));
        System.out.println(new Solution_LeetCode_13_RomanToInteger().romanToInt("MCMXCIV"));
    }
}

class Solution_LeetCode_13_RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if (map.containsKey(s)) {
            return map.get(s);
        } else {
            int sum = 0;
            for (int i = s.length()-1; i >=0; i--) {
                
                char ch = s.charAt(i);
                char nextCh = '\0';
                if (i + 1 != s.length()) {
                    nextCh = s.charAt(i + 1);
                }
                switch (ch) {
                    case 'I' :  if (nextCh == 'V' || nextCh == 'X') {
                                    sum -=1;
                                } else {
                                    sum +=1;
                                }
                                break;
                    case 'V' : sum +=5;
                        break;
                    case 'X' : if (nextCh == 'L' || nextCh == 'C') {
                                    sum -=10;
                                } else {
                                    sum +=10;
                                }       
                        break;
                    case 'L' : sum += 50;
                        break;
                    case 'C' : if (nextCh == 'D' || nextCh == 'M') {
                                    sum -=100;
                                } else {
                                  sum +=100;
                                }
                                break;
                    case 'D' : sum += 500;
                        break;
                    case 'M' : sum += 1000;
                        break;   

                }
            }
            map.put(s, sum);
            return sum;
        }  
    }
}