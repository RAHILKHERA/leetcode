public class LeetCode_1716_CalculateMoneyinLeetCodeBank {

}

class Solution_LeetCode_1716_CalculateMoneyinLeetCodeBank {

    public int totalMoney(int n) {

        int div = n / 7;
        byte mod = (byte) (n % 7);
       
        /**
         * This is an arithmetic progression. 
         * For full weeks the total will be the summation of the AP. 
         * Formula : Sn = n/2 {2a + (n-1)d} 
         * Here n is div. 
         * a is the first term that is the total of the first week = 28.
         * d  = 7 as there are 7 days in the week and the total increase by 7 every week.
         * 
         * Inputing above values in the equation it is reduced to 
         * total = (7 div^2 + 49 * div)/2; 
         */
        
        int total = (7*div*div + 49 * div)/2; 
        
        if (mod != 0) {

            for (int i = 1; i <= mod; i++) {
                 total += div + i;               
            }
        }

        return total;
    }
}