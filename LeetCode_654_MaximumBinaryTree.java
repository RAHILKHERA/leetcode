import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class LeetCode_654_MaximumBinaryTree {

    @Test
    public void test() {

        constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        creatTree(nums);
        return createTree(nums, 0, nums.length - 1);

    }

    private TreeNode createTree(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = left; i <= right; i++) {
            max = max > nums[i] ? max : nums[i];
            maxIndex = max > nums[i] ? maxIndex : i;
        }

        TreeNode node = new TreeNode(max);

        node.left = createTree(nums, left, maxIndex - 1);
        node.right = createTree(nums, maxIndex + 1, right);

        return node;

    }

    private TreeNode creatTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int n : nums) {
            TreeNode cur = new TreeNode(n);
            while (!stack.isEmpty() && stack.peek().val < n) {
                cur.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }

}
