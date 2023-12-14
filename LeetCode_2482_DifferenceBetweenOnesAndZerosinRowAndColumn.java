public class LeetCode_2482_DifferenceBetweenOnesAndZerosinRowAndColumn {
    public int[][] onesMinusZeros(int[][] grid) {
     
        int [][] diff = new int[grid.length][grid[0].length];
        int [] rows = new int [grid.length];
        int [] columns = new int [grid[0].length];
       
        for (int i = 0; i < grid.length; i++) {
            
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1) {
                    rows[i]++;
                    columns[j]++;
                }    
            }
        }

        int total = grid.length + grid[0].length;

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                diff[i][j] = 2 * (rows[i] + columns[j]) - total; 
            }
        }


        return diff;
    }
}

