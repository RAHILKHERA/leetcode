import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LeetCode_2751_RobotCollisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;

        List<Integer> result = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        char[] directionsArray = directions.toCharArray();

        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        Collections.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        for (int currentIndex : indices) {

            if (directionsArray[currentIndex] == 'R') {
                stack.push(currentIndex);
            } else {

                while (!stack.isEmpty() && healths[currentIndex] > 0) {

                    int top = stack.pop();

                    if (healths[top] == healths[currentIndex]) {
                        healths[top] = 0;
                        healths[currentIndex] = 0;
                    } else if (healths[top] > healths[currentIndex]) {
                        healths[top]--;
                        healths[currentIndex] = 0;
                        stack.push(top);
                    } else {
                        healths[top] = 0;
                        healths[currentIndex]--;
                    }
                }

            }

        }

        for (int health : healths) {
            if (health > 0) {
                result.add(health);
            }
        }

        return result;
    }
}
