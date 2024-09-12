public class LeetCode_988_SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder minimum = new StringBuilder();
        traversal(root, new StringBuilder(), minimum);
        return minimum.toString();
    }

    private void traversal(TreeNode node, StringBuilder builder, StringBuilder minimum) {

        if (node == null) {
            return;
        }

        builder.append((char) (node.val + 'a'));
        traversal(node.left, builder, minimum);
        traversal(node.right, builder, minimum);

        if (node.left == null && node.right == null) {
            if (minimum.length() == 0) {
                minimum.append(builder.reverse().toString());
            } else if (minimum.toString().compareTo(builder.reverse().toString()) > 0) {
                minimum.delete(0, minimum.length());
                minimum.append(builder.toString());

            }
            builder.reverse();
        }

        builder.deleteCharAt(builder.length() - 1);

    }

}
