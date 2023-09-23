public class LeetCode_167_TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int [] nums = {-1,0};
        int target = -1;
        new Solution_LeetCode_167_TwoSumIIInputArrayIsSorted().twoSum(nums, target);
    }
}

class Solution_LeetCode_167_TwoSumIIInputArrayIsSorted {
    public int [] twoSum(int [] numbers, int target) {
        
        int high = numbers.length - 1;
        int [] result = new int [2];
        
        for (int i = 0; i <= high; i++) {

            int firstNumber = numbers[i];
            int secondNumber = target - firstNumber;

            int index2 = binarySearch(numbers, i+1, high, secondNumber);
            if (index2 != -1) {
                result[0] = i + 1;
                result[1] = index2 + 1;
                return result;
            } 
        } 
        
        return result;
    }

    private int binarySearch(int[] numbers, int low, int high, int x) {
        

        if (high < low) {
            return -1;
        }

        if (x == numbers[low]) {
            return low;
        }

        if (x == numbers[high]) {
            return high;
        }

        int mid = low + (high - low) / 2;

        if (x == numbers[mid]) {
            return mid;
        } else  if (x > numbers[mid]){
            return binarySearch(numbers, mid + 1, high, x);
        } else {
            return binarySearch(numbers, low, mid -1 , x);
        }
    }
}


