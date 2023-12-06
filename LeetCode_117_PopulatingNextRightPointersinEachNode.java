public class LeetCode_117_PopulatingNextRightPointersinEachNode {

    public static void main(String[] args) {
         
        Node_117 node1 = new Node_117(1);
        Node_117 node2 = new Node_117(2);
        Node_117 node3 = new Node_117(3);
        Node_117 node4 = new Node_117(4);
        Node_117 node5 = new Node_117(5);
        Node_117 node6 = new Node_117(6);
        Node_117 node7 = new Node_117(7);
        Node_117 node8 = new Node_117(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node6.right = node8;

        Node_117 root = new Solution_LeetCode_117_PopulatingNextRightPointersinEachNode().connect(node1);

        System.out.println(root);
    }
    
}

class Solution_LeetCode_117_PopulatingNextRightPointersinEachNode {

    public Node_117 connect(Node_117 root) {

        if (root == null) {
            return root;
        }

        Node_117 head = root; 

        while (head != null) {
            Node_117 dummy = new Node_117(0);
            Node_117 temp = dummy; 

            while (head != null) {

                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }

                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.right;
                }

                head = head.next;
            }

            head = dummy.next;
        }

        return root;
    }

}

class Node_117 {
    public int val;
    public Node_117 left;
    public Node_117 right;
    public Node_117 next;

    public Node_117() {}
    
    public Node_117(int _val) {
        val = _val;
    }

    public Node_117(int _val, Node_117 _left, Node_117 _right, Node_117 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
