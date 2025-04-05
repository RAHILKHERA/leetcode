import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FindThePrefixCommonArray {

    @Test
    public void test() {
        assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 5, 6, 7, 8, 9, 10, 11, 11, 12, 13, 15, 16, 18,
                20, 22, 24, 25, 27, 29, 31, 33 },
                findThePrefixCommonArray(new int[] { 20, 2, 14, 19, 31, 9, 30, 13, 17, 33, 10, 3, 26, 28, 5, 8, 6, 29,
                        22, 21, 23, 4, 1, 27, 24, 11, 12, 18, 7, 25, 32, 16, 15 },
                        new int[] { 7, 1, 3, 5, 11, 2, 16, 26, 4, 13, 22, 23, 31, 9, 18, 19, 17, 8, 32, 12, 24, 25, 20,
                                28, 6, 33, 14, 30, 15, 21, 10, 29, 27 }));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        long a = 0;
        long b = 0;
        long unit = 1;
        for (int i = 0; i < n; i++) {
            a |= unit << A[i];
            b |= unit << B[i];
            result[i] = Long.bitCount(a & b);
        }
        return result;
    }
}
