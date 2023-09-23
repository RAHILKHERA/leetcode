import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_1337_TheKWeakestRowsInTheMatrix {
    
    public static void main(String[] args) {
        
        int [][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};

        new SolutionLeetCode_1337_TheKWeakestRowsInTheMatrix().kWeakestRows(mat, 3);
    
    }
    
}

class SolutionLeetCode_1337_TheKWeakestRowsInTheMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int [] soldiers = new int [mat.length];

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    soldiers[i]++;
                } else {
                    break;
                } 
            }
        }

        Integer [] indicies = new Integer [soldiers.length];

        for (int i = 0; i < indicies.length; i++) {
            indicies[i] = i;
        }

        Arrays.sort(indicies, (a,b) -> {

            if (soldiers[a] != soldiers[b]) {
                return Integer.compare(soldiers[a], soldiers[b]);
            } else {
                return Integer.compare(a, b);
            }
        });



        Arrays.sort(indicies, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (soldiers[a] != soldiers[b]) {
                    return Integer.compare(soldiers[a], soldiers[b]);
                } else {
                    return Integer.compare(a, b);
                }
            }
        });

        int [] results = new int [k];

        for (int i =0; i <k; i++) {
            results[i] = indicies[i];
        }

        return results;

    }
}
