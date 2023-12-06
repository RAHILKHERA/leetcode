public class LeetCode_201_BitWiseAndOfNumbersRange {
    public static void main(String[] args) {
        new Solution_LeetCode_201_BitWiseAndOfNumbersRange().rangeBitwiseAnd(1073741824, 2147483647);
    }
}

class Solution_LeetCode_201_BitWiseAndOfNumbersRange {
     public int rangeBitwiseAnd(int left, int right) {
      int shift = 0;

    while (left < right) {
        left >>= 1;
        right >>= 1;
        shift++;
    }

    return left << shift;
    }
}