public class LeetCode_19_RemoveNthNodeFromEndofList {

}

class Solution_LeetCode_19_RemoveNthNodeFromEndofList {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        
        int count = 0;
        //Only one node is available and that is deleted too. So returning null.
        if (head.next == null && n == 1) {
            return null;
        } 

        while (fast.next != null) {
            
            if (count == n) {
                slow = slow.next;
            } else {
                count++;
            }
            fast = fast.next;
        }
        
        //Delete head
        if (count != n) {
            ListNode del = head;
            head = head.next;
            del.next = null;
        } else if (slow.next.next != null) {
            ListNode del = slow.next;
            slow.next = slow.next.next;
            del.next = null;
        } else {
            //If deleting last node. 
            slow.next = null;
        }
           
        return head;    
    }
} 