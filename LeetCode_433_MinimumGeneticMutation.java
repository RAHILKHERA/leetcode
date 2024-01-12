import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class LeetCode_433_MinimumGeneticMutation {

    @Test
    public void test() {
        assertEquals(1, minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" }));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        int mutations = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String currentGene = queue.poll();

                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                for (int j = 0; j < 8; j++) {
                    for (char ch : new char[] { 'A', 'C', 'G', 'T' }) {
                        if (currentGene.charAt(j) != ch) {
                            String nextGene = currentGene.substring(0, j) + ch + currentGene.substring(j + 1);
                            if (bankSet.contains(nextGene)) {
                                queue.offer(nextGene);
                                bankSet.remove(nextGene);
                            }
                        }

                    }
                }
                mutations++;
            }
        }

        return mutations;
    }

}
