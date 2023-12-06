import static org.junit.Assert.assertFalse;

public class LeetCode_234_PalindromeLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        //ListNode node3 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        //node2.next = node3;

        assertFalse(new Solution_LeetCode_234_PalindromeLinkList().isPalindrome(head));
    }
}

class Solution_LeetCode_234_PalindromeLinkList {
    public boolean isPalindrome(ListNode head) {
        
        if (head.next == null) {
            return true;
        }
        
        ListNode slow = head, fast = head;
        boolean odd = false;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        odd = fast.next == null;
        ListNode  midNext = reverseList(slow.next);
        ListNode saveMidNext = midNext;
        slow.next = midNext;


        ListNode current = head;
        if (odd) {
            while (current != slow && midNext!= null) {
                if (current.val != midNext.val) {
                    return false;
                }
                current = current.next;
                midNext = midNext.next;
            }
        } else {
            while (current != saveMidNext && midNext!= null) {
                if (current.val != midNext.val) {
                    return false;
                }
                current = current.next;
                midNext = midNext.next;
            }
        }


        return true;
    }
    
    private ListNode reverseList (ListNode midNext) {

        ListNode current = midNext, next = null, prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
}
