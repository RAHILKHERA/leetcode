public class LeetCode_2816_DoubleANumberRepresnetedasaLinkedList {

    public ListNode doubleIt(ListNode head) {

        ListNode curr = head, prev = null, next = null;

        // Reverse the LinkList
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Add Each Node with Itself, to double it.
        head = prev;
        curr = prev;
        int carry = 0;
        while (curr != null) {
            int digit = curr.val + curr.val + carry;
            carry = digit >= 10 ? 1 : 0;
            curr.val = digit % 10;
            prev = curr;
            curr = curr.next;
        }

        if (carry == 1) {
            prev.next = new ListNode(carry);
        }

        curr = head;
        prev = null;
        next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    public ListNode doubleIt(ListNode head, boolean overflow) {

        int number = 0;

        while (head != null) {
            number = number * 10 + head.val;
            head = head.next;
        }

        number *= 2;

        if (number == 0) {
            return new ListNode(0);
        }

        ListNode curr = null, prev = null;

        while (number > 0) {

            int digit = number % 10;

            curr = new ListNode(digit);

            if (prev == null) {
                head = curr;
            } else {
                prev.next = curr;
            }

            prev = curr;
            number /= 10;
        }

        curr = head;
        prev = null;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
