import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CountVowelStringsinRanges {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                vowelStrings(new String[] { "bzmxvzjxfddcuznspdcbwiojiqf", "mwguoaskvramwgiweogzulcinycosovozppl",
                        "uigevazgbrddbcsvrvnngfrvkhmqszjicpieahs", "uivcdsboxnraqpokjzaayedf", "yalc",
                        "bbhlbmpskgxmxosft", "vigplemkoni", "krdrlctodtmprpxwditvcps", "gqjwokkskrb",
                        "bslxxpabivbvzkozzvdaykaatzrpe", "qwhzcwkchluwdnqjwhabroyyxbtsrsxqjnfpadi",
                        "siqbezhkohmgbenbkikcxmvz", "ddmaireeouzcvffkcohxus", "kjzguljbwsxlrd",
                        "gqzuqcljvcpmoqlnrxvzqwoyas", "vadguvpsubcwbfbaviedr", "nxnorutztxfnpvmukpwuraen",
                        "imgvujjeygsiymdxp", "rdzkpk", "cuap", "qcojjumwp", "pyqzshwykhtyzdwzakjejqyxbganow",
                        "cvxuskhcloxykcu", "ul", "axzscbjajazvbxffrydajapweci" },
                        new int[][] {

                                { 4, 4 }, { 6, 17 }, { 10, 17 }, { 9, 18 }, { 17, 22 }, { 5, 23 }, { 2, 5 }, { 17, 21 },
                                { 5, 17 }, { 4, 8 }, { 7, 17 }, { 16, 19 }, { 7, 12 }, { 9, 20 }, { 13, 23 }, { 1, 5 },
                                { 19, 19 }
                        }));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int q = queries.length;
        int[] prefixSum = new int[n];
        int[] result = new int[q];

        prefixSum[0] = isVowel(words[0].charAt(0)) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1];
            if (isVowel(words[i].charAt(0))) {
                prefixSum[i]++;
            }
        }

        for (int i = 0; i < q; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            result[i] = prefixSum[right];
            if (left > 0) {
                result[i] -= prefixSum[left - 1];
            }
        }

        return result;
    }

    public boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
