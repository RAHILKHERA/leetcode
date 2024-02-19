public class LeetCode_148_SortList {
    public ListNode sortList(ListNode head) {

        /**
         * If list is empty or just a single node, then no need to sort.
         */
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);

        return mergeList(head1, head2);
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {

        ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode, previousNode = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                currentNode = head1;
                head1 = head1.next;
            } else {
                currentNode = head2;

                head2 = head2.next;
            }
            previousNode.next = currentNode;
            previousNode = currentNode;
        }

        if (head1 != null) {
            previousNode.next = head1;
        }

        if (head2 != null) {
            previousNode.next = head2;
        }

        return dummyNode.next;
    }
}
