public class LeetCode_86_PartitionList {
    
}

class Solution_LeetCode_86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        
        ListNode lower = null, lowerCurrent, lowerPrevious = null, 
                higher = null, higherCurrent, higherPrevious = null, current = head;

        while (current != null) {
            if (current.val < x) {
                if(lower == null) {
                    lower = new ListNode(current.val);
                    lowerPrevious = lower;
                } else {    
                    lowerCurrent = new ListNode(current.val);
                    lowerPrevious.next = lowerCurrent;
                    lowerPrevious = lowerCurrent;
                }
            } else {
                if (higher == null) {
                    higher = new ListNode(current.val);
                    higherPrevious = higher;
                } else {
                    higherCurrent = new ListNode(current.val);
                    higherPrevious.next = higherCurrent;
                    higherPrevious = higherCurrent;
                }
            }
            current = current.next;
        }

        lowerPrevious.next = higher;
        return lower;
    }
}
