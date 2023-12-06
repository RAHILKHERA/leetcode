import static org.junit.Assert.assertEquals;


public class LeetCode_8_StringToInteger_atoi {

    public static void main(String[] args) {
        //assertEquals(42, new Solution_LeetCode_8_StringToInteger_atoi().myAtoi("42"));
        //assertEquals(-42, new Solution_LeetCode_8_StringToInteger_atoi().myAtoi("   -42"));
        //assertEquals(4193, new Solution_LeetCode_8_StringToInteger_atoi().myAtoi("4193 with words"));
        //assertEquals(-1123, new Solution_LeetCode_8_StringToInteger_atoi().myAtoi( " -1123u3761867"));
        //assertEquals(0, new Solution_LeetCode_8_StringToInteger_atoi().myAtoi( "00000-42a1234"));
        assertEquals(-2147483648, new Solution_LeetCode_8_StringToInteger_atoi().myAtoi("-91283472332"));

    }
    
}

class Solution_LeetCode_8_StringToInteger_atoi {
    
    public int myAtoi(String s) {
        
        long result = 0;
        int index = 0;
        Character ch = null;

        while(index < s.length()) {

            ch  = s.charAt(index);
            if (ch.equals(' ')) {
                index++;
            } else {
                break;
            }
        }
        
        if (index == s.length()) {
            return (int) result;
        }

        boolean isPositive = true;

        if (ch.equals('-')) {
            isPositive = false;
            index++;
        } else if (ch.equals('+')) {
            index++;
        }

        

        while (index < s.length()) {

            ch = s.charAt(index);
            
            if (Character.isDigit(ch)) {
               
                result = result * 10  + Character.getNumericValue(ch);

                if (isPositive && result >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } 

                if (!isPositive && result > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
                index++;
            } else {
                break;
            }
        }
       
        result = isPositive ? result : result * -1;
        return (int)result;
    }
}
