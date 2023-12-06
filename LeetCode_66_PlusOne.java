import static org.junit.Assert.assertArrayEquals;


public class LeetCode_66_PlusOne {
    public static void main(String[] args) {
        Solution_LeetCode_66_PlusOne solution = new Solution_LeetCode_66_PlusOne();
        assertArrayEquals(new int []{1,0,0,0}, solution.plusOne(new int [] {9,9,9}));  
    }
    
}

class Solution_LeetCode_66_PlusOne {
    public int [] plusOne(int [] digits) {

        int sum = digits [digits.length -1] + 1;
        int carry = sum > 9 ? 1 : 0;
        digits[digits.length -1] = carry == 1 ? 0 : sum;
        
        for (int i = digits.length - 2; i >=0; i--) {
            
            if (carry == 1) {
                sum = digits[i] + carry;
                carry = sum > 9 ? 1:0;
                digits[i] = carry == 1 ? 0 : sum;
            } 
        }

        if (carry == 1) {
            int [] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                result [i+1] = digits[i];
            }

            return result;
        }

        return digits;
    }
}
