public class LeetCode_1278_ElementAppearingMoreThan25PercentInSortedArray {
    
}

class Solution_LeetCode_1278_ElementAppearingMoreThan25PercentInSortedArray {

    public int findSpecialInteger(int[] arr) {
        
        int candidate = arr[0], count = 0;

        for (int num : arr) {
            
            if (candidate == num) {
                count++;
            } else {
                count = 1; 
                candidate = num;
            }

            if (count > arr.length/4) {
                return candidate; 
            }
        }

        return candidate;
    }
}
