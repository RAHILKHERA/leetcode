public class LeetCode_136_SingleNumber {
    
}

class Solution_LeetCode_136_SingleNumber {
    public int singleNumber(int[] nums) {
        int number = 0;
        for (int num : nums) {
            number ^= num;
        }
        return number;
    }
}
