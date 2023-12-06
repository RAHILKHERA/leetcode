public class LeetCode_707_DesignLinkList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));              // return 3

    }
}


class MyLinkedList {

    ListNode_LL head;
    
    int length;

    public MyLinkedList() {}
    
    public int get(int index) {
        
        if (index < 0 || index > length - 1) {
            return -1;
        }
        
        if (index == 0) return head.val;
        
        ListNode_LL current = head;

        while (index > 0) {
            current = current.next;
            index--;
        }
        return current.val;       
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);    
    }
    
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }
    
    public void addAtIndex(int index, int val) {

        if (index > length) {
            return;
        }
        
        ListNode_LL node = new ListNode_LL(val);

        if (head == null) {
            head = node; 
            length++;
            return; 
        }

        if (index == 0) {
            node.next = head;
            head = node;
            length++;
            return; 
        } 

        ListNode_LL current = head;
        
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;
        length++;
        
    }
    
    public void deleteAtIndex(int index) {
        
        if (index <0 || index > length - 1) {
            return; 
        }

        if (index == 0) {
            ListNode_LL delNode = head;
            head = head.next;
            delNode.next = null;
        } else {
            ListNode_LL current = head;
            
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            ListNode_LL delNode = current.next;
            current.next = current.next.next;
            delNode.next = null;
        }
        length--;
    }
}


class ListNode_LL {
    int val;
    ListNode_LL next;

    ListNode_LL () {

    }

    ListNode_LL(int val) { 
        this.val = val; 
        this.next = null;
    }
}