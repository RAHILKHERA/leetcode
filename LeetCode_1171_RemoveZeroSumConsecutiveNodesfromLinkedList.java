import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LeetCode_1171_RemoveZeroSumConsecutiveNodesfromLinkedList {

    @Test
    public void test1() {

        ListNode nodeF = new ListNode(-1);
        ListNode nodeE = new ListNode(-1, nodeF);
        ListNode nodeD = new ListNode(1, nodeE);
        ListNode nodeC = new ListNode(-2, nodeD);
        ListNode nodeB = new ListNode(2, nodeC);
        ListNode nodeA = new ListNode(2, nodeB);

        ListNode result = removeZeroSumSublists(nodeA);
        System.out.println(result.toString());
    }

    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        prefixSumMap.put(0, dummy);

        while (head != null) {
            prefixSum += head.val;

            if (prefixSumMap.containsKey(prefixSum)) {

                ListNode start = prefixSumMap.get(prefixSum);
                ListNode temp = start.next;
                int subPrefixSum = prefixSum;
                while (temp != head) {

                    subPrefixSum += temp.val;
                    if (prefixSumMap.get(subPrefixSum) != dummy) {
                        prefixSumMap.remove(subPrefixSum);
                    }
                    temp = temp.next;

                }
                start.next = head.next;
                head.next = null;
                head = start.next;

            } else {
                prefixSumMap.put(prefixSum, head);
                head = head.next;
            }
        }

        return dummy.next;
    }
}
