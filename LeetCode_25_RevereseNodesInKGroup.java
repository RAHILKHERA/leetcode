import org.junit.Test;

public class LeetCode_25_RevereseNodesInKGroup {

    @Test
    public void test1() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        reverseKGroup(node1, 5);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        int saveK = k;

        ListNode previousEnd = dummyNode, nextStart = head, groupStart, groupEnd = head;

        while (nextStart != null) {
            groupStart = nextStart;
            while (nextStart != null && k != 0) {
                groupEnd = nextStart;
                nextStart = nextStart.next;
                k--;
            }

            if (k != 0) {
                break;
            }

            groupEnd.next = null;

            ListNode[] reverseList = new ListNode[2];
            reverseList = reverse(groupStart);

            previousEnd.next = reverseList[0];
            reverseList[1].next = nextStart;
            previousEnd = reverseList[1];
            k = saveK;
        }

        return dummyNode.next;
    }

    private ListNode[] reverse(ListNode node) {

        ListNode[] list = new ListNode[2];

        ListNode previous = null, current = node, next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        list[0] = previous;
        list[1] = node;

        return list;
    }
}
