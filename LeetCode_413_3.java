import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class LeetCode_413_3 {

    @Test
    public void test1() {

        List<List<Integer>> grid = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);

        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(3);
        row2.add(2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(1);
        row3.add(1);

        grid.add(row1);
        grid.add(row2);
        grid.add(row3);

        assertEquals(8, maxScore(grid));
    }

    public int maxScore(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();
        int result = 0;

        for (List<Integer> row : grid) {
            Collections.sort(row, Collections.reverseOrder());
        }

        for (int index = 0; index < n; index++) {

            Set<Integer> set = new HashSet<>();
            int sum = grid.get(0).get(index);
            set.add(grid.get(0).get(index));

            for (int i = 1; i < m; i++) {

                for (int j = 0; j < n; j++) {
                    int element = grid.get(i).get(j);
                    if (!set.contains(element)) {
                        set.add(element);
                        sum += element;
                        break;
                    }

                }
            }
            result = Math.max(result, sum);
        }

        return result;
    }
}
