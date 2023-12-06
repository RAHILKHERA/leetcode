import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class LeetCode_274_H_Index {

    public static void main(String[] args) {
        assertEquals(3, new Solution_LeetCode_274_H_Index().hIndex(new int []{3,0,6,1,5}));
        assertEquals(1, new Solution_LeetCode_274_H_Index().hIndex(new int []{1,3,1}));
        assertEquals(0, new Solution_LeetCode_274_H_Index().hIndex(new int []{0,0,0}));
        assertEquals(5, new Solution_LeetCode_274_H_Index().hIndex(new int []{5,5,5,5,5,5}));
    }
    
}

class Solution_LeetCode_274_H_Index {
    public int hIndex(int [] citations) {
        
        Arrays.sort(citations);

        int hIndex = citations.length;

        while (hIndex > 0) {

            int count = 0;
            for (int i = 0; i < citations.length; i++) {
                
                if (citations[i] >= hIndex) {
                    count++;
                    if (count == hIndex) {
                        break;
                    }    
                } else if (citations[i] < hIndex && (citations.length-i-1) <  hIndex) {
                    hIndex--;
                    break;
                } 
            }

            if (count == hIndex) {
                break;
            } 
        }
        return hIndex;
    }
}
