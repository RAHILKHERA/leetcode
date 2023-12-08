
public class LeetCode_606_ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        
        // TreeNode node7 = new TreeNode(7);
        // TreeNode node6 = new TreeNode(6);
        // TreeNode node5 = new TreeNode(5);
        // TreeNode node4 = new TreeNode(4);
        // TreeNode node2 = new TreeNode(2, node4, node5);
        // TreeNode node3 = new TreeNode(3, node6, node7);
        // TreeNode node1 = new TreeNode(1, node2, node3);

    
        // TreeNode node4 = new TreeNode(4);
        // TreeNode node2 = new TreeNode(2, node4, null);
        // TreeNode node3 = new TreeNode(3, null, null);
        // TreeNode node1 = new TreeNode(1, node2, node3);


        // TreeNode node4 = new TreeNode(4);
        // TreeNode node2 = new TreeNode(2, null, node4);
        // TreeNode node3 = new TreeNode(3, null, null);
        // TreeNode node1 = new TreeNode(1, node2, node3);


        // TreeNode node2 = new TreeNode(2, null, null);
        // TreeNode node3 = new TreeNode(3, null, null);
        // TreeNode node1 = new TreeNode(1, node2, node3);

        TreeNode node1 = new TreeNode(1, null, null);

        new Solution_LeetCode_606_ConstructStringFromBinaryTree().tree2str(node1);

    }
}

class Solution_LeetCode_606_ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        
        preoreder(root, builder);

        return builder.toString();
    }

    private void preoreder(TreeNode node, StringBuilder builder) {

    
        builder.append(node.val);

        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            builder.append("(");
            preoreder(node.left, builder);
            builder.append(")(");
            preoreder(node.right, builder);
            builder.append(")");
            return;
        }

        if (node.left == null && node.right != null) {
            builder.append("()(");
            preoreder(node.right, builder);
            builder.append(")");
            return;
        }

        if (node.left != null && node.right == null) {
            builder.append("(");
            preoreder(node.left, builder);
            builder.append(")");
        }
    }
}
