public class LeetCode_190_ReverseBits {

    public static void main(String[] args) {
        new Solution_LeetCode_190_ReversBits().reverseBits(43261596);
    }
    
}

class Solution_LeetCode_190_ReversBits {
    public int reverseBits(int n) {
        int result = 0;
        int numberOfBits = 32; // Assuming a 32-bit integer

        for (int i = 0; i < numberOfBits; i++) {
            // Shift the result to the left to make space for the next bit, and then bitwise OR it with the current bit from the input.
            result = (result << 1) | (n & 1);
            // Right-shift the input to process the next bit.
            n >>= 1;
        }
       
        return result;
    }
}
