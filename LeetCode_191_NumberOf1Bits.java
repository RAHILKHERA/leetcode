public class LeetCode_191_NumberOf1Bits {
    public static void main(String[] args) {
         new Solution_LeetCode_191_NumberOf1Bits().hammingWeight(00000000000000000000000000001011);
    }
}

class Solution_LeetCode_191_NumberOf1Bits {
    public int hammingWeight(int n) {
       int result = 0;
        int numberOfBits = 32; // Assuming a 32-bit integer

        for (int i = 0; i < numberOfBits; i++) {
            int bit = n & 1;
            if (bit == 1) {
                result++;
            }
            // Right-shift the input to process the next bit.
            n >>= 1;

            if ( n == 0) {
                return result;
            }
        }
       
        return result;
    }
}
