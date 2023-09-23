import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_15_3Sum {
   
    public static void main(String[] args) {

        int [] nums = {-1,0,1,2,-1,-4};
        new Solution_LeetCode_15_3Sum().threeSum(nums);
    }
}

class Solution_LeetCode_15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        
        HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        Arrays.sort(nums);

        for (int i =0; i < nums.length; i++) {

            int firstNumber = nums[i];

            if (!map.containsKey(firstNumber) && firstNumber <=0) {
              
                for (int j = nums.length - 1; j > i; j--) {
                    int secondNumber = nums[j];
                    if (secondNumber >=0) {
                        int thirdNumber =  0 - firstNumber - secondNumber;
                        boolean findThirdNumber = binarySearch(nums, i+1, j-1, thirdNumber);
                        if (findThirdNumber) {
                            List<Integer> tuple = new ArrayList<>();
                            tuple.add(firstNumber);
                            tuple.add(secondNumber);
                            tuple.add(thirdNumber);
                            List<List<Integer>> tupleList = null;
                            if (map.containsKey(firstNumber)) {
                                tupleList = map.get(firstNumber);
                            } else {
                                tupleList = new ArrayList<List<Integer>>();
                            }
                            tupleList.add(tuple);
                            map.put(firstNumber, tupleList);
                        }
                    }
                    
                }
            } 
        }

        List<List<Integer>> resultList = map.values()  
                                        .stream()
                                        .flatMap(List::stream)
                                        .collect(Collectors.toList());
        return resultList;
    }

    private boolean binarySearch (int[] nums, int low, int high, int x) {

        int mid = low + (high - low)/2;

        if (high < low) {
            return false;
        }

        if (nums[mid] == x) {
            return true;
        } else if (nums[mid] < x) {
            return binarySearch(nums, mid + 1, high, x);
        } else {
            return binarySearch(nums, low, mid - 1, x);
        }
    
    }
}
