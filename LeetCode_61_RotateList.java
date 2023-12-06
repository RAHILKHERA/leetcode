public class LeetCode_61_RotateList {
    
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        new Solution_LeetCode_61_RotateList().rotateRight(list1, 2);
    }
}

class Solution_LeetCode_61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        
        int length = 0;

        ListNode slow = head, fast = head;
        while (slow != null) {
            length++;
            slow = slow.next;
        }

        k = k % length;
        slow = head;
        int count = 0;

        while (fast.next != null) {
            
            if (count < k) {
                count++;
            }  else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;


        return head;
    }
}
