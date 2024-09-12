import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_1442_CountTripletsThatCanFormTwoArraysofEqualXOR {

    @Test
    public void test1() {
        assertEquals(4, countTriplets(new int[] { 2, 3, 1, 6, 7 }));

    }

    public int countTriplets(int[] arr) {

        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }

        for (int i = -1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int currXor = i == -1 ? 0 : arr[i];
                if ((currXor) == arr[j]) {
                    count += j - i - 1;
                }
            }
        }

        return count;
    }
}
