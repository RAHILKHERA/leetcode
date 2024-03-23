import java.util.ArrayList;

public class LeetCode_349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        int[] freq = new int[1001];
        int count = 0;

        for (int i : nums1) {
            if (freq[i] == 0) {
                freq[i]++;
            }
        }

        for (int i : nums2) {
            if (freq[i] > 0) {
                freq[i]++;
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < freq.length; i++) {

            if (freq[i] == 2) {
                result[index] = i;
                index++;
            }
        }

        return result;

    }

    public int[] intersectionWithArrayList(int[] nums1, int[] nums2) {

        int[] freq = new int[1001];

        for (int i : nums1) {
            freq[i]++;
        }

        ArrayList<Integer> intersection = new ArrayList<>();

        for (int i : nums2) {
            if (freq[i] > 0) {
                intersection.add(i);
                freq[i] = 0;
            }
        }

        int[] result = new int[intersection.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = intersection.get(i);
        }

        return result;

    }
}
