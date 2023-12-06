import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode_1630_ArithmeticSubarrays {
    
}

class Solution_LeetCode_1630_ArithmeticSubArrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> result = new ArrayList<>();
    
        for (int i = 0; i < l.length; i++) {
            result.add(isArithmetic(nums, l[i], r[i]));
        }
        
        return result;
    }

    private boolean isArithmetic(int [] nums, int l, int r) {

        int[] subArray = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(subArray);

        int diff = subArray[1] - subArray[0];
        for (int i = 1; i < subArray.length - 1; i++) {
            if (subArray[i + 1] - subArray[i] != diff) {
                return false;
            }
        }

        return true;

    }
}

