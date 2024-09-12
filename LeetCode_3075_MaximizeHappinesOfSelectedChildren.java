import java.util.Arrays;

public class LeetCode_3075_MaximizeHappinesOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {

        long result = 0;
        Arrays.sort(happiness);

        int currentK = 0;
        for (int i = happiness.length - 1; i >= 0; i--) {
            int currentHappiness = happiness[i] - currentK;
            result += currentHappiness >= 0 ? currentHappiness : 0;
            currentK++;
            if (currentK == k) {
                break;
            }
        }

        return result;
    }
}
