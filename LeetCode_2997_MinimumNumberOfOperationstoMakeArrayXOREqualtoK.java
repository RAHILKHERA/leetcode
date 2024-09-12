public class LeetCode_2997_MinimumNumberOfOperationstoMakeArrayXOREqualtoK {
    public int minOperations(int[] nums, int k) {

        int result = 0;
        int xor = 0;

        /**
         * Finding xor of all the elements (xor), we have to find minimum number of
         * operations to make this equal to k.
         */

        for (int i : nums) {
            xor ^= i;
        }

      
        /**
         * Perform ^ between xor and k and count number of set bits. The number of set
         * bits will the required number of bits required to change.
         */

        xor ^= k;

        while (xor != 0) {

            result += xor & 1;

            xor >>= 1;
        }

        return result;
    }
}
