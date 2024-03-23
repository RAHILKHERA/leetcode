public class LeetCode_1669_MergeInBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        // Find the node at position a-1
        ListNode prev = dummy;
        for (int i = 0; i <= a - 1; i++) {
            prev = prev.next;
        }

        // Find the node at position b
        ListNode current = prev.next;
        for (int i = 0; i < b - a + 1; i++) {
            current = current.next;
        }

        // Connect the previous node to list2 and list2 to the next node after b
        prev.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = current;

        return dummy.next;
    }
}
