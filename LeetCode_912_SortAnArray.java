public class LeetCode_912_SortAnArray {
    public int[] sortArray(int[] nums) {

        return mergeSort(nums, 0, nums.length);
    }

    private int[] mergeSort(int[] nums, int left, int right) {

        if (right - left <= 1) {
            if (right == left) {
                return new int[] { nums[left] };
            } else if (nums[left] < nums[right]) {
                return new int[] { nums[left], nums[right] };
            } else {
                return new int[] { nums[right], nums[left] };
            }

        }

        int mid = left + (right - left) / 2;
        int[] leftArray = mergeSort(nums, left, mid - 1);
        int[] rightArray = mergeSort(nums, mid, right);
        int result[] = new int[leftArray.length + rightArray.length];
        int i = 0, j = 0, index = 0;

        while (i < leftArray.length && j < rightArray.length) {

            if (leftArray[i] < rightArray[i]) {
                result[index++] = leftArray[i++];
            } else {
                result[index++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            result[index++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            result[index++] = rightArray[j++];
        }

        return result;
    }
}
