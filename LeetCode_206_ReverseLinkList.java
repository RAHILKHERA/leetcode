public class LeetCode_206_ReverseLinkList {
    
}

class Solution_LeetCode_206_ReverseLinkList {
     public ListNode reverseList(ListNode head) {
        ListNode current = head, next = null, prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}