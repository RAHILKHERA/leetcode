public class LeetCode_1512_NumberOfGoodPairs {
    
}

class Solution_LeetCode_1512_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
           
        int [] cnt = new int [101];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        } 

        for (int i = 1; i < 101; i++) {
            if (cnt[i] > 1)  {
                count += (cnt[i] * (cnt[i] - 1) * 0.5);  
            }
        }
        
        return count;
    }
}
