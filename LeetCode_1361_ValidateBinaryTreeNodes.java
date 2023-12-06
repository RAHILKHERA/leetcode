import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_1361_ValidateBinaryTreeNodes {

}

class Solution_LeetCode_1361_ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int head = -1;

        for (int i = 0; i < n; i++) {
            int lChild = leftChild[i];
          

            if (lChild != -1) {
                if (parent[lChild] != -1) {
                    // Found cycle through left child.
                    return false;
                } else {
                    parent[lChild] = i;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            int rChild = rightChild[i];
            if (rChild != -1) {
                if (parent[rChild] != -1) {
                    // Found cycle through right child.
                    return false;
                } else {
                    parent[rChild] = i;
                }
            }

        }

        int countNodesWithoutParent = 0;

        for (int i = 0; i < n; i ++) { 
            int num = parent[i];

            if (num != -1 && (num == leftChild[i] || num == rightChild[i])) {
                return false;
            } 

            if (num == -1) {
                head = i;
                countNodesWithoutParent++;
            }

            if (num == -1 && leftChild[i] == -1 && rightChild[i] == -1 && n > 1) {
                return false; 
            }

            if (countNodesWithoutParent > 1) {
                return false;
            }
        }

        if (countNodesWithoutParent == 0) {
            return false;
        }

        

        return traverseTree(head, head, leftChild, rightChild, new HashSet<Integer>());
    }

    private boolean traverseTree(int head, int index, int [] leftChild, int[] rightChild, HashSet<Integer> set) {
        
        set.add(index);

        if (leftChild[index] != -1) {
            traverseTree(head, leftChild[index], leftChild, rightChild, set);
        }

        if (rightChild[index] != -1) {
            traverseTree(head, rightChild[index], leftChild, rightChild, set);
        }

        return (head == index && set.size() == leftChild.length);
        
    }
}