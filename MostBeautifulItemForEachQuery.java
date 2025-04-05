import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class MostBeautifulItemForEachQuery {

    @Test
    public void test1() {
        assertArrayEquals(
                new int[] { 962, 962, 962, 962, 746, 962, 962, 962, 946, 962, 962, 919, 746, 746, 962, 962, 962, 919,
                        962 },
                maximumBeauty(new int[][] { { 193, 732 }, { 781, 962 }, { 864, 954 }, { 749, 627 }, { 136, 746 },
                        { 478, 548 }, { 640, 908 }, { 210, 799 }, { 567, 715 }, { 914, 388 }, { 487, 853 },
                        { 533, 554 },
                        { 247, 919 }, { 958, 150 }, { 193, 523 }, { 176, 656 }, { 395, 469 }, { 763, 821 },
                        { 542, 946 },
                        { 701, 676 } },
                        new int[] { 885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479,
                                1180, 875, 276, 1584 }));
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        int[] results = new int[m];

        Arrays.sort(items, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < m; i++) {

            int left = 0;
            int right = n - 1;
            int beauty = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (items[mid][0] <= queries[i]) {
                    beauty = Math.max(beauty, items[mid][1]);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            results[i] = beauty;

        }
        return results;
    }
}
