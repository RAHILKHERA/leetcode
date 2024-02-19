public class LeetCode_108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {

        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = createBST(nums, left, mid - 1);
        node.right = createBST(nums, mid + 1, right);

        return node;
    }
}
