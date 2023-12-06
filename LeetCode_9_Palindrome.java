import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LeetCode_9_Palindrome {
    public static void main(String[] args) {
        assertTrue(new Solution_LeetCode_9_Palindrome().isPalindrom(0));
        assertTrue(new Solution_LeetCode_9_Palindrome().isPalindrom(121));
        assertTrue(new Solution_LeetCode_9_Palindrome().isPalindrom(1331));
        assertFalse(new Solution_LeetCode_9_Palindrome().isPalindrom(-121));
        
   
    }
}

class Solution_LeetCode_9_Palindrome {
    public boolean isPalindrom (int x) {
        if (x < 0) {
            return false; 
        }

        if (x == 0) {
            return true; 
        }
  
        int sum = 0, originalNumber = x;
        while (x > 0) {

            sum = sum * 10 + x % 10;
            x/=10;
        }

        return sum == originalNumber;
    }
}