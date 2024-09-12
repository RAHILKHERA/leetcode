import java.util.Arrays;

public class LeetCode_881_BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {

        int boats = 0;
        int left = 0, right = people.length - 1;

        Arrays.sort(people);

        while (left <= right) {
            int remaining = limit - people[right];
            boats++;
            right--;
            if (left <= right && remaining - people[left] <= limit) {
                left++;
            }
        }

        return boats;
    }
}
