public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {

        if (next != null) {
            return "{ value : " + val + ", next : " + next.toString() + "}";
        }

        return "{ value : " + val + ", next : null}";
    }

}
