public class LeetCode_21_MergeTwoSortedLists {
    
}

class Solution_LeetCode_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = null, previousNode = null, currentNode = null;
        int value = 0;
        while (list1 != null && list2 != null) {
            
            if (list1.val < list2.val) {
                value = list1.val;
                list1 = list1.next;
            } else  {
                value = list2.val;
                list2 = list2.next;
            } 

            if (head == null) {
                head = new ListNode(value);
                previousNode = head;
                currentNode = head;
            } else {
                currentNode = new ListNode(value);
                previousNode.next = currentNode;
                previousNode = currentNode;
            }
        }

        if (list1 != null) {
            copyRemainingList(list1, head, previousNode, currentNode);
        }

        if (list2 != null) {
            copyRemainingList(list2, head, previousNode, currentNode);
        }

        return head;
    }

    private void copyRemainingList(ListNode list, ListNode head, ListNode previousNode, ListNode currentNode) {
       
        while (list != null) {
            
            if (head == null) {
                head = new ListNode(list.val);
                previousNode = head;
                currentNode = head;
            } else {
                currentNode = new ListNode(list.val);
                previousNode.next = currentNode;
                previousNode = currentNode;
            }
            list = list .next;
        }
    }

}
