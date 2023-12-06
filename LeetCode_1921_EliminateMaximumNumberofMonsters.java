import java.util.Arrays;

public class LeetCode_1921_EliminateMaximumNumberofMonsters {
    public static void main(String[] args) {
        new Solution_LeetCode_1921_ElminiateMaximumNumberofMonsters().eliminateMaximum(new int [] {4,2,3}, new int []{2,1,1});
    }
}

class Solution_LeetCode_1921_ElminiateMaximumNumberofMonsters {
    
    public int eliminateMaximum(int[] dist, int[] speed) {
    
        int result = 1; 
        double [] time = new double [dist.length];
        for (int i = 0; i < dist.length; i++) {
            time[i] = (double)dist[i]/speed[i];    
        } 

        Arrays.sort(time);

        for (int i = 0; i < time.length - 1; i++) {
            if((time[i+1] - time[i]) >= 1) {
                result++;
            } else if (time[i] == time[i+1] && time[i] != 1) {
                result++;
            } else {
                return result;
            }
        }
        
        return result; 
    }
}
 