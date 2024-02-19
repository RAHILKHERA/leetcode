public class LeetCode_645_SetMismatch {
    public int[] findErrorNums(int[] nums) {

        int[] map = new int[nums.length + 1];

        for (int num : nums) {
            map[num]++;
        }

        int dup = 0, miss = 0;

        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0) {
                miss = i;
            }

            if (map[i] == 2) {
                dup = i;
            }

        }

        return new int[] { dup, miss };
    }
}
