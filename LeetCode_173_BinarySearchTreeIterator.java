public class LeetCode_173_BinarySearchTreeIterator {
    public static void main(String[] args) {

        // TreeNode node14 = new TreeNode(14, null, null);
        // TreeNode node21 = new TreeNode(21, null, null);
        // TreeNode node23 = new TreeNode(23, null, null);
        // TreeNode node13 = new TreeNode(13, null, node14);
        // TreeNode node17 = new TreeNode(17, null, null);
        // TreeNode node22 = new TreeNode(22, node21, node23);
        // TreeNode node12 = new TreeNode(12, null, node13);
        // TreeNode node18 = new TreeNode(18, node17, null);
        // TreeNode node20 = new TreeNode(20, null, node22);
        // TreeNode node5 = new TreeNode(5, null, null);
        // TreeNode node15 = new TreeNode(15, node12, null);
        // TreeNode node19 = new TreeNode(19, node18, node20);
        // TreeNode node6 = new TreeNode(6, node5, null);
        // TreeNode node8 = new TreeNode(8, null, null);
        // TreeNode node10 = new TreeNode(10, null, null);
        // TreeNode node16 = new TreeNode(16, node15, node19);
        // TreeNode node28 = new TreeNode(28, null, null);
        // TreeNode node7 = new TreeNode(7, node6, node8);
        // TreeNode node11 = new TreeNode(11, node10, node16);
        // TreeNode node25 = new TreeNode(25, null, null);
        // TreeNode node27 = new TreeNode(27, null, node28);
        // TreeNode node33 = new TreeNode(33, null, null);
        // TreeNode node9 = new TreeNode(9, node7, node11);
        // TreeNode node26 = new TreeNode(26, node25, node27);
        // TreeNode node31 = new TreeNode(31, null, null);
        // TreeNode node34 = new TreeNode(34, node33, null);
        // TreeNode node3 = new TreeNode(3, null, null);
        // TreeNode node4 = new TreeNode(4, node3, node9);
        // TreeNode node29 = new TreeNode(29, node26, null);
        // TreeNode node32 = new TreeNode(32, node31, node34);
        // TreeNode node0 = new TreeNode(0, null, null);
        // TreeNode node2 = new TreeNode(2, null, node4);
        // TreeNode node30 = new TreeNode(30, node29, node32);
        // TreeNode node36 = new TreeNode(36, null, null);
        // TreeNode node1 = new TreeNode(1, node0, node2);
        // TreeNode node35 = new TreeNode(35, node30, node36);
        // TreeNode node45 = new TreeNode(45, null, null);
        // TreeNode node47 = new TreeNode(47, null, null);
        // TreeNode node38 = new TreeNode(38, null, null);
        // TreeNode node40 = new TreeNode(40, null, null);
        // TreeNode node43 = new TreeNode(43, null, null);
        // TreeNode node46 = new TreeNode(46, node45, node47);
        // TreeNode node49 = new TreeNode(49, null, null);
        // TreeNode node24 = new TreeNode(24, node1, node35);
        // TreeNode node39 = new TreeNode(39, node38, node40);
        // TreeNode node42 = new TreeNode(42, null, node43);
        // TreeNode node48 = new TreeNode(48, node46, node49);
        // TreeNode node37 = new TreeNode(37, node24, node39);
        // TreeNode node44 = new TreeNode(44, node42, node48);
        // TreeNode node41 = new TreeNode(41, node37, node44);

        // BSTIterator iterator = new BSTIterator(node41);



        //iterator.hasNext();

        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node10 = new TreeNode(10);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        TreeNode node16 = new TreeNode(16);

        node10.left = node5;
        node10.right = node15;
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        node1.left = node0;
        node15.left = node14;
        node14.left = node13;
        node13.left = node12;
        node15.right = node16;
        node6.right = node7;

        BSTIterator iterator = new BSTIterator(node10);
        iterator.hasNext();

    }
}

class BSTIterator {

    private TreeNode root;
    
    public BSTIterator(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.right = root;
        flattenTree(dummyNode, null);
        this.root = dummyNode;
    }
    
    public int next() {
        int val = root.right.val;
        root = root.right;
        return val;
    }
    
    public boolean hasNext() {
        return root.right == null;
    }

    private TreeNode flattenTree(TreeNode node, TreeNode parent) {

        if (node == null) {
            return null;
        }

        TreeNode leftNode = null, rightNode = null;
        if (node.left != null) {
            leftNode = flattenTree(node.left, node);
            node.left = leftNode;
        }

        if (node.right != null) {
            rightNode = flattenTree(node.right, node);
            node.right = rightNode;
        }

        if (leftNode == null && rightNode == null) {
            return node;
        }

        if (leftNode != null) {
            if (leftNode.right != null) {
                TreeNode rightMost = leftNode.right;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = node;
                
            } else {
                leftNode.right = node;    
            }
            node.left = null;
            return leftNode;
        }
    
        return node;
    }
}
