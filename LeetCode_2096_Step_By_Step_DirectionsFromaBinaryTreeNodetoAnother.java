public class LeetCode_2096_Step_By_Step_DirectionsFromaBinaryTreeNodetoAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode lca = LCA(root, startValue, destValue);
        StringBuilder source = new StringBuilder();
        getPath(lca, startValue, source);
        StringBuilder destination = new StringBuilder();
        getPath(lca, destValue, destination);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            result.append("U");
        }

        for (int i = 0; i < destination.length(); i++) {
            result.append(destination.charAt(i));
        }
        return result.toString();
    }

    private boolean getPath(TreeNode node, int value, StringBuilder builder) {

        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        }

        builder.append("L");
        boolean found = getPath(node.left, value, builder);
        if (!found) {
            builder.deleteCharAt(builder.length() - 1);
            builder.append("R");
            found = getPath(node.right, value, builder);

            if (!found) {
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return found;

    }

    private TreeNode LCA(TreeNode root, int startValue, int destValue) {

        if (root == null) {
            return null;
        }

        if (root.val == startValue || root.val == destValue) {
            return root;
        }

        TreeNode left = LCA(root.left, startValue, destValue);
        TreeNode right = LCA(root.right, startValue, destValue);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;

    }
}
