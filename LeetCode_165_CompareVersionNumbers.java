import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_165_CompareVersionNumbers {

    @Test
    public void test1() {
        assertEquals(-1, compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {

        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");

        int numberOfRevisions = revisions1.length > revisions2.length ? revisions1.length : revisions2.length;

        int[] revisionNumber1 = new int[numberOfRevisions];
        int[] revisionNumber2 = new int[numberOfRevisions];

        for (int i = 0; i < revisions1.length; i++) {
            revisionNumber1[i] = Integer.parseInt(revisions1[i]);
        }

        for (int i = 0; i < revisions2.length; i++) {
            revisionNumber2[i] = Integer.parseInt(revisions2[i]);
        }

        for (int i = 0; i < numberOfRevisions; i++) {
            if (revisionNumber1[i] < revisionNumber2[i]) {
                return -1;
            } else if (revisionNumber1[i] > revisionNumber2[i]) {
                return 1;
            }
        }

        return 0;
    }
}
