public class LeetCode_1051_HeightChecker {
    public int heightChecker(int[] heights) {

        int count[] = new int[101];
        int diff = 0;
        for (int height : heights) {
            count[height]++;
        }

        int index = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    if (heights[index] != i) {
                        diff++;
                    }
                    index++;

                }
            }
        }
        return diff;
    }
}
