import java.util.ArrayList;
import java.util.List;

public class LeetCode_257_BinaryTreePaths {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;

        new Solution_LeetCode_257_BinaryTreePaths().binaryTreePaths(node1);
    }
}

class Solution_LeetCode_257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // postorder(root, paths, path);
        // for (List<TreeNode> ipath : paths) {

        // boolean firstNode = true;
        // StringBuilder builder = new StringBuilder();
        // for (TreeNode t : ipath) {

        // if (firstNode) {
        // builder.append(t.val);
        // firstNode = false;
        // } else {
        // builder.append("->").append(t.val);
        // }

        // }
        // result.add(builder.toString());
        // }

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        postorder(root.left, result, new StringBuilder().append(root.val));
        postorder(root.right, result, new StringBuilder().append(root.val));

        return result;
    }

    // private void postorder(TreeNode node, List<List<TreeNode>> paths,
    // List<TreeNode> path) {

    // if (node == null) {
    // return;
    // }

    // path.add(node);

    // if (node.left == null && node.right == null) {
    // paths.add(path);
    // }

    // postorder(node.left, paths, new ArrayList<>(path));

    // postorder(node.right, paths, new ArrayList<>(path));

    // }

    private void postorder(TreeNode node, List<String> paths, StringBuilder path) {

        if (node == null) {
            return;
        }

        path.append("->").append(node.val);

        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        }

        postorder(node.left, paths, new StringBuilder(path.toString()));

        postorder(node.right, paths, new StringBuilder(path.toString()));

    }
}