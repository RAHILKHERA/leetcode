public class LeetCode_2_AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;


        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;

        new Solution_LeetCode_2_AddTwoNumbers().addTwoNumbers(l11, l21);

        // ListNode l11 = new ListNode(0);
        // ListNode l21 = new ListNode(0);

        // new Solution_LeetCode_2_AddTwoNumbers().addTwoNumbers(l11, l21);

        // ListNode l11 = new ListNode(9);
        // ListNode l12 = new ListNode(9);
        // ListNode l13 = new ListNode(9);
        // ListNode l14 = new ListNode(9);
        // ListNode l15 = new ListNode(9);
        // ListNode l16 = new ListNode(9);
        // ListNode l17 = new ListNode(9);
        // l11.next = l12;
        // l12.next = l13;
        // l13.next = l14;
        // l14.next = l15;
        // l15.next = l16;
        // l16.next = l17;




        // ListNode l21 = new ListNode(9);
        // ListNode l22 = new ListNode(9);
        // ListNode l23 = new ListNode(9);
        // ListNode l24 = new ListNode(9);
        // l21.next = l22;
        // l22.next = l23;
        // l23.next = l24;

        // new Solution_LeetCode_2_AddTwoNumbers().addTwoNumbers(l11, l21);


        // ListNode l11 = new ListNode(9);
       




        // ListNode l21 = new ListNode(1);
        // ListNode l22 = new ListNode(9);
        // ListNode l23 = new ListNode(9);
        // ListNode l24 = new ListNode(9);
        // ListNode l25 = new ListNode(9);
        // ListNode l26 = new ListNode(9);
        // ListNode l27 = new ListNode(9);
        // ListNode l28 = new ListNode(9);
        // ListNode l29 = new ListNode(9);
        // ListNode l210 = new ListNode(9);
        
        // l21.next = l22;
        // l22.next = l23;
        // l23.next = l24;
        // l24.next = l25;
        // l25.next = l26;
        // l26.next = l27;
        // l27.next = l28;
        // l28.next = l29;
        // l29.next = l210;
        // new Solution_LeetCode_2_AddTwoNumbers().addTwoNumbers(l11, l21);
    }
} 

class Solution_LeetCode_2_AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode();
        ListNode previousNode = head, currentNode = head;
        boolean headSet = false;
        int carry = 0, total = 0;   

        while (l1 != null || l2 != null) {
            
            total = 0;

            if (l1 != null && l2!= null) {
                total = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if  (l2 != null) {
                total = l2.val + carry;
                l2 = l2.next;
            } else if (l1 != null) {
                total = l1.val + carry;
                l1 = l1.next;
            }

            if (total > 9) {
                total %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            if (headSet) {
                currentNode = new ListNode(total);
                previousNode.next = currentNode;
                previousNode = currentNode;

            } else {
                head.val = total;
                headSet = true;
            }

        }

        if (carry == 1) {
            currentNode = new ListNode(1);
            previousNode.next = currentNode;
        }

        return head;
    }

    

  
 }


