public class LeetCode_237_DeleteNodeinLinkList {
    public void deleteNode(ListNode node) {

        // ListNode prevNode = null, currNode = node;

        // while (currNode.next != null) {
        // currNode.val = currNode.next.val;
        // prevNode = currNode;
        // currNode = currNode.next;
        // }

        // prevNode.next = null;

        // Overwrite data of next node on current node.
        node.val = node.next.val;
        // Make current node point to next of next node.
        node.next = node.next.next;

    }
}
