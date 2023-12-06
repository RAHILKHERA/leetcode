import java.util.ArrayList;

public class LeetCode_55_JumpGame {
    public static void main(String[] args) {
        new Solution_LeetCode_55_JumpGame().canJump(new int [] {3,2,1,0,4});    
    }
    
}

class Solution_LeetCode_55_JumpGame {
    public boolean canJump (int [] nums ) {
        
        if (nums.length == 1) {
            return true;
        } 

        int x = nums.length - 1;
        Node_JumpGame root = new Node_JumpGame(0);
        return root.traverseNodes( x, nums);
    }
}

class Node_JumpGame {

    private int index;
    private ArrayList<Node_JumpGame> childNodes;

    public ArrayList<Node_JumpGame> getChildNodes() {
        return childNodes;
    }

    public Node_JumpGame (int index) {
        this.index = index;
        childNodes = new  ArrayList<Node_JumpGame>();
    }

    public void generateChildren(int value, int x, int [] nums ) {

        int childIndex = index + 1;
        for (int i = 0; i < value; i++) {
             Node_JumpGame node = new Node_JumpGame(childIndex);
             childNodes.add(node);
             childIndex++;
        }
    }

    public boolean traverseNodes(int x, int [] nums) {

        boolean found = false;
        
        if (this.index == x) {
            return true;
        } else {

            if (this.getChildNodes().size() == 0 && this.index < nums.length - 1 && nums[this.index] > 0) {
                this.generateChildren(nums[this.index], x, nums);
            }


            for (Node_JumpGame node : getChildNodes()) {
                found = node.traverseNodes(x, nums);
                if (found) {
                    return found;
                }
            }
        }
        return found;
    }
}