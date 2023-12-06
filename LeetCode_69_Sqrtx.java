import java.util.HashMap;

public class LeetCode_69_Sqrtx {
    public static void main(String[] args) {
        new Solution_LeetCode_69_Sqrtx().mySqrt(2147483647);
    }
}

class Solution_LeetCode_69_Sqrtx {
    
    private static HashMap<Long, Integer> map = new HashMap<Long, Integer>();

    
    
    public int mySqrt(int x) {
        
        if (x == 0) {
            return 0;
        }
        
        long left = 1;
        long right = x / 2 + 1;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            
            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int) right;
    }
}
