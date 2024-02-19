public class LeetCode_23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;

        ListNode head1 = divide(lists, left, mid);
        ListNode head2 = divide(lists, mid + 1, right);

        return merge(head1, head2);

    }

    public ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy, previous = dummy;

        while (head1 != null && head2 != null) {

            if (head1.val < head2.val) {
                current = head1;
                head1 = head1.next;
            } else {
                current = head2;
                head2 = head2.next;
            }
            previous.next = current;
            previous = current;
        }

        if (head1 != null) {
            previous.next = head1;
        }

        if (head2 != null) {
            previous.next = head2;
        }

        return dummy.next;
    }
}
