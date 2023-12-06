public class LeetCode_82_RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        new Solution_LeetCode_82_RemoveDuplicatesFromSortedList2().deleteDuplicates(head);
    }
}

class Solution_LeetCode_82_RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current.next != null) {
            boolean isDuplicate = false;
            
            while (current.next.next != null && current.next.val == current.next.next.val) {
                current.next = current.next.next; // Skip all occurrences of the duplicate
                isDuplicate = true;
            }
            
            if (isDuplicate) {
                current.next = current.next.next; // Skip the last occurrence of the duplicate
            } else {
                current = current.next; // Move to the next distinct node
            }
        }
        
        return dummy.next;
    }
}
