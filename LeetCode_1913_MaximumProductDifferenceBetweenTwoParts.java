public class LeetCode_1913_MaximumProductDifferenceBetweenTwoParts {
    
    public int maxProductDifference(int[] nums) {
        
        int max = 0, max2 = 0, min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num > max) {
                max2 = max;
                max = num;
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min) {
                min2 = min;
                min = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (max * max2) - (min * min2);
        
    }
}
