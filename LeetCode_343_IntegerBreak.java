public class LeetCode_343_IntegerBreak {
    
    public static void main(String[] args) {
        int ans = new Solution_LeetCode_343_IntegerBreak().integerBreak(5);
        System.out.println(ans);
    }

}

class Solution_LeetCode_343_IntegerBreak {

    private static int [] dp = new int[59];
    
    static {
        dp [1] = 1;
    }

    public int integerBreak (int n) {
        
        if (n == 1) {
            return 1;
        } else if (dp[n] != 0){
            return dp[n];
        } else {
            int i = 1;
            int ans = 0; 
            while (i < n) {
                
                int firstNumber = i;
                int secondNumber = n - i;
                int product = firstNumber * Math.max(secondNumber, integerBreak(secondNumber));
                
                if (product > ans) {
                    ans = product; 
                }
                i++;
            }
            dp [n] = ans;
            return ans;
        }
    }
}
