public class LeetCode_143_ReorderList {

    public void reorderList(ListNode head) {

        ListNode midpoint = null, slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        midpoint = slow.next;
        slow.next = null;

        ListNode list1 = head, list2 = reverseList(midpoint);

        while (list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;
            list1.next = list2;
            list2.next = next1;
            list1 = next1;
            list2 = next2;
        }

    }

    private ListNode reverseList(ListNode node) {

        ListNode current = node, previous = null, next = null;

        while (current != null) {

            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;

    }

}