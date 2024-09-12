import java.util.Arrays;

public class LeetCode_2191_SorttheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {

        int[][] mappedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            mappedNums[i][0] = nums[i];
            mappedNums[i][1] = getMappedNumber(mapping, nums[i]);
        }

        // Step 2: Sort the pairs array based on the mapped values
        Arrays.sort(mappedNums, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return 0; // Maintain relative order
            }
        });

        // Step 3: Extract the sorted original numbers back to the nums array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = mappedNums[i][0];
        }

        return nums;
    }

    private int getMappedNumber(int[] mapping, int num) {

        if (num == 0) {
            return mapping[0];
        }

        int mappedNumber = 0;
        int multiplier = 1;

        while (num > 0) {
            int digit = num % 10;
            digit = mapping[digit];
            mappedNumber += digit * multiplier;
            num /= 10;
            multiplier *= 10;
        }
        return mappedNumber;
    }
}
