import java.util.Arrays;

public class LeetCode_3132_FindTheIntegerAddedToArray2 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int num1 = nums1[(nums1.length - 1) / 2];
        int num2 = nums2[(nums2.length - 1) / 2];

        return num2 - num1;
    }
}
