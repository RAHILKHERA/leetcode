package Week16_2025;

/**
 * LeetCode Problem: 2179 Count Good Triplets in an array.
 * Problem Link: https://leetcode.com/problems/count-good-triplets-in-an-array/
 * 
 * Definitions :
 * #1 Good Triplet : if pos1v is the index of the value v in nums1 and pos2v as
 * the index of the value v in nums2, then a good triplet will be a
 * set (x, y, z) where 0 <= x, y, z <= n - 1, such that pos1x < pos1y < pos1z
 * and pos2x < pos2y < pos2z.
 * 
 * Note: nums1 and nums2 are permutation of each other and contains elements
 * from 0 to n -1.
 * 
 * Task : To count total number of good triplets.
 * 
 * Observation :
 * #1 When triplets (x,y,z) is in the question, it is better to fix the middle
 * element 'y' and find other two. As this creates a partition.
 * #2 Fixing y at position pos, if it is know that 'X' elements on left and 'Z'
 * elements on
 * right satisfy the condition, total count will be X*Z.
 * #3. X' = pos - X. (number of elements in nums1 which are on left of y but are
 * on right in nums2) i.e. number of elements that doesn't qualify for triplet.
 * #4. If it is known at what index y is present in nums2, it can be calculated
 * number of elements on right of it nums2. This can be achieved by maintaining
 * a reverse mapping i.e. value vs index (idx). => Z' = (n - 1) - idx. -1 to
 * remove the element Y.
 * #5. Z' is total of the elements which are on the right side of y in nums1 and
 * the number of elements which are on the left side in nums1 but on right side
 * on nums2. => Z = Z' - X'
 * #6 Summation of Count for each element in nums1 = X * (Z' - (pos - X)).
 * #7 Finding number of elements on left of Y in nums1 which are also on left of
 * Y in nums2.
 * a) Execute a query from idx 0 to pos (index of Y) and find out X.
 * b) Running this query for every element in nums1 except 1st and last, as
 * those can't be the middle elements => use segment tree.
 * #8 As nums1 is traversed, each idx from nums2 of the element is marked as
 * visited in segment tree.
 * 
 * Approach:
 * 1) Create map of element vs index for nums2.
 * 2) Mark first element as visited. There are no elements on left of first
 * element so this cannot be a middle element.
 * 3) X = query segment tree for range 0 to idx. -> idx = index of the element
 * in nums2. Fetch it from map. pos = index of the element in nums1.
 * 4) X' = pos - X
 * 5) Z' = (n - 1) - X' (number of elements on right side of the idx).
 * 6) Z = Z' - X'.
 * 7) count += X * Z.
 * 8) mark current element's index in nums2 as visited in segment tree.
 * 
 * 
 * Time Complexity: O(nlogn) => a) Creation of map takes O(n).
 * b) Traverse nums1, update and query of segment tree takes O(logn) => O(nlogn)
 * 
 * Space Complexity: O(n) => a) extra array of n elements for map.
 * b) extra array of 4 * n elements for segment tree.
 * => O(5*n) => O(n)
 */
public class LeetCode_2179_CountGoodTripletsInAnArray {
    private class SegmentTree {

        long[] segmentTree;

        SegmentTree(int n) {
            segmentTree = new long[4 * n];
        }

        public void updateSegmentTree(int pos, int left, int right, int idx) {
            if (left == right) {
                segmentTree[pos] = 1; // visited
                return;
            }

            int mid = left + (right - left) / 2;
            if (idx <= mid) {
                updateSegmentTree(2 * pos + 1, left, mid, idx);
            } else {
                updateSegmentTree(2 * pos + 2, mid + 1, right, idx);
            }
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }

        public long querySegmentTree(int queryStart, int queryEnd, int pos, int left, int right) {
            if (right < queryStart || left > queryEnd) {
                return 0;
            }

            if (left >= queryStart && right <= queryEnd) {
                return segmentTree[pos];
            }

            int mid = left + (right - left) / 2;

            long leftTreeValue = querySegmentTree(queryStart, queryEnd, 2 * pos + 1, left, mid);
            long rightTreeValue = querySegmentTree(queryStart, queryEnd, 2 * pos + 2, mid + 1, right);

            return leftTreeValue + rightTreeValue;
        }

    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] map = new int[n];
        for (int pos = 0; pos < n; pos++) {
            map[nums2[pos]] = pos;
        }

        long result = 0;

        SegmentTree st = new SegmentTree(n);

        st.updateSegmentTree(0, 0, n - 1, map[nums1[0]]);

        for (int pos = 1; pos < n - 1; pos++) {
            int idx = map[nums1[pos]]; // index in nums2;
            long leftCommonCount = st.querySegmentTree(0, idx, 0, 0, n - 1);
            long leftNotCommonCount = pos - leftCommonCount;
            long elementsAfterIdxNum2 = (n - 1) - idx;
            long rightCommonCount = elementsAfterIdxNum2 - leftNotCommonCount;
            result += leftCommonCount * rightCommonCount;
            st.updateSegmentTree(0, 0, n - 1, idx);
        }

        return result;
    }
}
