public class LeetCode_876_MiddleOftheLinkList {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            slow = slow.next;
        }

        return slow;
    }
}
