import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode_752_OpenTheLock {
    public int openLock(String[] deadends, String target) {

        Map<Character, Character> nextMap = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0');

        Map<Character, Character> previousMap = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8');

        Set<String> visitedCombinations = new HashSet<>(Arrays.asList(deadends));
        Queue<String> pendingCombinations = new LinkedList<>();

        if (visitedCombinations.contains("0000")) {
            return -1;
        }

        int turns = 0;
        pendingCombinations.offer("0000");
        visitedCombinations.add("0000");

        while (!pendingCombinations.isEmpty()) {

            int level = pendingCombinations.size();

            for (int i = 0; i < level; i++) {

                String currentCombination = pendingCombinations.poll();

                if (currentCombination.equals(target)) {
                    return turns;
                }

                for (int wheel = 0; wheel < 4; wheel++) {

                    StringBuilder builder = new StringBuilder(currentCombination);

                    builder.setCharAt(wheel, nextMap.get(currentCombination.charAt(wheel)));

                    if (!visitedCombinations.contains(builder.toString())) {
                        pendingCombinations.add(builder.toString());
                        visitedCombinations.add(builder.toString());

                    }

                    builder = new StringBuilder(currentCombination);
                    builder.setCharAt(wheel, previousMap.get(currentCombination.charAt(wheel)));

                    if (!visitedCombinations.contains(builder.toString())) {
                        pendingCombinations.add(builder.toString());
                        visitedCombinations.add(builder.toString());
                    }
                }

                turns++;
            }
        }

        return -1;
    }
}
