
public class LeetCode_155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    
}

class MinStack {

    // private PriorityQueue<LinkListStack> minHeap;
    // private LinkListStack head; 

    // public MinStack() {
    //     minHeap = new PriorityQueue<LinkListStack>((a, b) -> {return Integer.compare(a.data, b.data);});
    // }
    
    // public void push(int val) {
    //     LinkListStack node = new LinkListStack(val);
    //     if (head != null) {
    //         node.next = head;
    //         head = node; 
    //     } else {
    //         head = node;
    //     }
    //     minHeap.add(node);
       
    // }
    
    // public void pop() {

    //     minHeap.remove(head);
    //     head = head.next;
    // }
    
    // public int top() {        
    //     return head.data;
    // }
    
    // public int getMin() {
    //     return minHeap.peek().data;
    // }

    private LinkListStack head; 
    private LinkListStack minHead;

    public MinStack() {
        
    }
    
    public void push(int val) {
        
        LinkListStack node = new LinkListStack(val);
        if (head != null) {
            node.next = head;  
        }
        head = node;


        LinkListStack minNode = new LinkListStack(val);
        if (minHead != null) {
            minNode.data = Math.min(val, minHead.data);
            minNode.next = minHead;
        } 
        minHead = minNode;
        
    }
    
    public void pop() {
        
        head = head.next;
        minHead = minHead.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return minHead.data;
    }
}

class LinkListStack {

    int data; 
    LinkListStack next; 

    LinkListStack (int data) {
        this.data = data;
    }
}
