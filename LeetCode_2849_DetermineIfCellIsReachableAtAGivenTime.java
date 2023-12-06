public class LeetCode_2849_DetermineIfCellIsReachableAtAGivenTime {
    
}

class Solution_LeetCode_2849_DetermineIfCellIsReachableAtAGivenTime {
     public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        if(sx == fx && sy == fy) {
            return false;
        }

       return Math.max(Math.abs(fx -sx), Math.abs(fy - sy)) <= t;
        
        
       
    }
}