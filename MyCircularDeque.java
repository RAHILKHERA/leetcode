import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyCircularDeque {

    @Test
    public void test1() {
        MyCircularDeque q = new MyCircularDeque(8);
        assertTrue(q.insertFront(5));
        assertEquals(5, q.getFront());
        assertFalse(q.isEmpty());
        assertTrue(q.deleteFront());
        assertTrue(q.insertLast(3));
        assertEquals(3, q.getRear());
        assertTrue(q.insertLast(7));
        assertTrue(q.insertFront(7));
        assertTrue(q.deleteLast());
        assertTrue(q.insertLast(4));
        assertFalse(q.isEmpty());

    }

    class ListNode {
        ListNode prev;
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    private int length = 0;
    private ListNode front;
    private ListNode back;
    private int capacity = 0;

    public MyCircularDeque(int k) {
        capacity = k;
    }

    public boolean insertFront(int value) {

        if (length == capacity) {
            return false;
        }

        ListNode newNode = new ListNode(value);

        if (front == null && back == null) {
            front = newNode;
            back = newNode;
            length++;
            return true;
        }

        newNode.next = front;
        front.prev = newNode;
        front = newNode;
        length++;
        return true;

    }

    public boolean insertLast(int value) {

        if (length == capacity) {
            return false;
        }

        ListNode newNode = new ListNode(value);

        if (front == null && back == null) {
            front = newNode;
            back = newNode;
            length++;
            return true;
        }

        back.next = newNode;
        newNode.prev = back;
        back = newNode;
        length++;
        return true;
    }

    public boolean deleteFront() {

        if (length == 0) {
            return false;
        }

        ListNode currentFront = front;
        front = front.next;
        if (front != null) {
            front.prev = null;
        }
        currentFront.next = null;
        length--;
        return true;
    }

    public boolean deleteLast() {

        if (length == 0) {
            return false;
        }

        ListNode currentLast = back;
        back = back.prev;
        if (back != null) {
            back.next = null;
        }
        currentLast.prev = null;
        length--;
        return true;

    }

    public int getFront() {
        return front.val;
    }

    public int getRear() {
        return back.val;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
