

public class LeetCode_134_GasStation {
 public static void main(String[] args) {
    //System.out.println(new Solution_LeetCode_134_GasStation().canCompleteCircuit(new int[] {1,2,3,4,5}, new int []{3,4,5,1,2}));
    System.out.println(new Solution_LeetCode_134_GasStation().canCompleteCircuit(new int[] {3,1,1}, 
    
    new int []{1,2,2}));
 }
}

class Solution_LeetCode_134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas.length == 1 && gas[0] >= cost[0]) {
            return 0;
        }

    
           
                return -1;
    }

    
}
