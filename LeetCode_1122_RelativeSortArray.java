public class LeetCode_1122_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length];
        int[] count = new int[1001];

        for (int i : arr1) {
            count[i]++;
        }

        int index = 0;

        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]] > 0) {
                result[index++] = arr2[i];
                count[arr2[i]]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }

        return result;
    }
}
