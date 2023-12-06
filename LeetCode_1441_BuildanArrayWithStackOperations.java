import java.util.ArrayList;
import java.util.List;
public class LeetCode_1441_BuildanArrayWithStackOperations {
    public static void main(String[] args) {
        //new Solution_LeetCode_1441_BuildanArrayWithStackOperations().buildArray(new int [] {1,3}, 3);
        //new Solution_LeetCode_1441_BuildanArrayWithStackOperations().buildArray(new int [] {1,2,3}, 3);
        // new Solution_LeetCode_1441_BuildanArrayWithStackOperations().buildArray(new int [] {1,2}, 4);
        new Solution_LeetCode_1441_BuildanArrayWithStackOperations().buildArray(new int [] {10,15}, 20);
    }
}

class Solution_LeetCode_1441_BuildanArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> result = new ArrayList<>();
        int max = target[target.length - 1];
        int index = 0;
        for (int i = 1; i <= max; i++) {
            result.add("Push");
            if (target[index] != i) {
                result.add("Pop");
            } else {
                index++;
                if (index == target.length) {
                    break;
                }
            }
        }    

        return result;
    }
}
