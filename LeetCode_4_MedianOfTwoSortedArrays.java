import static org.junit.Assert.assertEquals;

public class LeetCode_4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        

    //  double median =  new Solution_LeetCode_4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int []{1,3}, new int []{2});
    //  assertEquals(2.00000, median, 0);

    //  double median =  new Solution_LeetCode_4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int []{1,2}, new int []{3,4});
    //  assertEquals(2.50000, median, 0);

    // double median =  new Solution_LeetCode_4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int []{2}, new int []{});
    // assertEquals(2.00000, median, 0);    1

    // double median =  new Solution_LeetCode_4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int []{0,0,0,0,0}, new int []{-1,0,0,0,0,0,1});
    // assertEquals(0.00000, median, 0);


    // double median =  new Solution_LeetCode_4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int []{}, new int []{2,3});
    // assertEquals(2.50000, median, 0);

    double median =  new Solution_LeetCode_4_MedianOfTwoSortedArrays().findMedianSortedArrays(new int []{2,2,4,4}, new int []{2,2,4,4});
    assertEquals(3.00000, median, 0);


    }
}

class Solution_LeetCode_4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0) {
            return medianOfSingleSortedArray(nums2);
        }

        if (nums2.length == 0) {
            return medianOfSingleSortedArray(nums1);
        }

        int totalLength = nums1.length + nums2.length;
        boolean evenMergedList = totalLength % 2 == 0;
        int indexOfMedian = totalLength / 2;
        int pointer1 = 0, pointer2 = 0, pointer3 = 0;
        int[] mergedArray = new int[indexOfMedian + 1];

        while (pointer1 < nums1.length && pointer2 < nums2.length) {

            if (nums1[pointer1] < nums2[pointer2]) {
                mergedArray[pointer3] = nums1[pointer1];
                pointer1++;
                pointer3++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                mergedArray[pointer3] = nums2[pointer2];
                pointer2++;
                pointer3++;
            } else {
                mergedArray[pointer3] = nums1[pointer1];
                pointer1++;
                pointer3++;
                if (pointer3 < mergedArray.length) {
                    mergedArray[pointer3] = nums2[pointer2];
                    pointer2++;
                    pointer3++;
                }
            }
            

            if (pointer3 == mergedArray.length) {
                break;
            }
        }

        if (pointer3 < mergedArray.length) {

            while (pointer1 < nums1.length && pointer3 < mergedArray.length) {

                mergedArray[pointer3] = nums1[pointer1];
                pointer1++;
                pointer3++;
            }

            while (pointer2 < nums2.length && pointer3 < mergedArray.length) {

                mergedArray[pointer3] = nums2[pointer2];
                pointer2++;
                pointer3++;
            }
        }

        if (evenMergedList) {

            return 1.0 * ((double)(mergedArray[mergedArray.length - 1] + mergedArray[mergedArray.length - 2]) / 2);

        } else {
            return 1.0 * mergedArray[mergedArray.length - 1];
        }
    }

    private double medianOfSingleSortedArray(int[] nums) {

        double result = 1.00;
        
            int index1 = nums.length / 2;

            if (nums.length % 2 == 0) {
                result *= (double)(nums[index1 - 1] + nums[index1]) / 2;
            } else {
                result *= nums[index1];
            }
        
        return result;
    }
}
