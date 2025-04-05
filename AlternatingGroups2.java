import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlternatingGroups2 {
    
    @Test
    public void test1() {
        assertEquals(0, 0);
    }
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int misMatchIndex = -1;
        int count = 0;

        for (int pos = 1; pos < k; pos++) {
            if (colors[pos] == colors[pos-1]) {
                misMatchIndex = pos-1;
            }
        }

        if (misMatchIndex == -1) count++;
        int idx = k;
        while (idx < 2*n) {
            int pos = idx % n;
            int prev = pos == 0 ? n - 1 : pos - 1;
            if (colors[pos] != colors[prev]) {
                int startIndex = pos - k + 1;
                if (startIndex > misMatchIndex) {
                    count++;
                }
            } else {
                misMatchIndex = prev;
            }
            idx++;
        }
        return count;
    }
}
