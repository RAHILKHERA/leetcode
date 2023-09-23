package DoublyLinkList;

public class DLL {
    
    Node headNode = null, tailNode = null;

    /**
     * @param data
     */
    public void createDLL(int data) {

        Node temp = new Node(data);
        if (headNode == null) {

            headNode = temp;
            tailNode = temp;
            headNode.setNext(null);
            headNode.setPrevious(null);
            tailNode.setNext(null);
            tailNode.setPrevious(null);
        } else  {
            tailNode.setNext(temp);
            temp.setPrevious(tailNode);
            tailNode = temp;
        }
    }

    /**
     * 
     */
    public void displayDLL() {
        Node current = null;

        if (headNode == null) {
            System.out.println("DLL is empty");
        } else {
            current = headNode;
            while (current != null) {
                System.out.println("Data :" + current.getData());
                current = current.getNext();
            }
        }
    }

    /**
     * 
     */
    public void displayReverseDLL() {
        Node current = null;

        if (tailNode == null) {
            System.out.println("DLL is empty");
        } else {
            current = tailNode;
            while (current != null) {
                System.out.print(" " + current.getData());
                current = current.getPrevious();
            }
            System.out.println();
        }

    }

    /**
     * @param afterValue
     * @param data
     * @return
     */
    public boolean addAfter(int afterValue, int data) {
        Node current = headNode;

        while (current != null) {
            if (current.getData() == afterValue) {
                Node temp = new Node(data);
                temp.setNext(current.getNext());
                temp.setPrevious(current);
                current.setNext(temp);
                Node next = temp.getNext();
                if (next != null) {
                    next.setPrevious(temp);    
                } else {
                    tailNode = temp;
                }
                temp = null;
                return true;
            } else {
                current = current.getNext();
            }
        }
        return false;
    } 

    /**
     * @param args
     */
    public static void main (String[] args) {

        DLL dll = new DLL();
        dll.createDLL(1);
        System.out.println("After Adding 1");
        dll.displayDLL();
        dll.displayReverseDLL();
        dll.createDLL(4);
        System.out.println("After Adding 4");
        dll.displayDLL();
        dll.displayReverseDLL();
        dll.addAfter(1, 2);
        System.out.println("After Adding 2");
        dll.displayDLL();
        dll.displayReverseDLL();
        dll.addAfter(2, 3);
        System.out.println("After Adding 3");
        dll.displayDLL();
        dll.displayReverseDLL();
        dll.addAfter(4, 5);
        System.out.println("After Adding 5");
        dll.displayDLL();
        dll.displayReverseDLL();
    }
}
