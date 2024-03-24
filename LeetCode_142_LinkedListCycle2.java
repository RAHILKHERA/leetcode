public class LeetCode_142_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}