public class LeetCode_1379_FindACoorespondingNodeOfBinaryTreeInACloneTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        if (original.left != null) {
            TreeNode result = getTargetCopy(original.left, cloned.left, target);
            if (result != null) {
                return result;
            }
        }

        if (original.right != null) {
            TreeNode result = getTargetCopy(original.right, cloned.right, target);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

}
