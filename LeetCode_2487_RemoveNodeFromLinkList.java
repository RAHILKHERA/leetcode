import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_2487_RemoveNodeFromLinkList {
    public ListNode removeNodes(ListNode head) {

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode current = head;

        while (current != null) {
            while (!stack.isEmpty() && current.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(current);
            current = current.next;
        }

        ListNode prev = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = prev;
            prev = node;
        }

        return prev;
    }
}
