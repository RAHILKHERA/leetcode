public class LeetCode_11_ContainerWithMostWater {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};

        new Solution_LeetCode_11_ContainerWithMostWater().maxArea(height);
    }
}

class Solution_LeetCode_11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {

            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if ( height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; 
    }  
}
