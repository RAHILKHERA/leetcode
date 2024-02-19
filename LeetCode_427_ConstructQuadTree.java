public class LeetCode_427_ConstructQuadTree {

    public static void main(String[] args) {

        new LeetCode_427_ConstructQuadTree().construct(new int[][] { { 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 0, 0, 0 } });
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructTree(grid, 0, n - 1, 0, n - 1, n);

    }

    public Node constructTree(int[][] grid, int startRow, int endRow, int startCol, int endCol, int length) {

        if (length == 1) {
            Node node = new Node(grid[endRow][endCol] == 1, true);
            return node;
        }

        int newLength = length / 2;

        Node topLeft = constructTree(grid, startRow, startRow + newLength - 1, startCol, startCol + newLength - 1,
                newLength); // Top Left
        Node topRight = constructTree(grid, startRow, startRow + newLength - 1, startCol + newLength, endCol,
                newLength); // Top right
        Node bottomLeft = constructTree(grid, startRow + newLength, endRow, startCol, startCol + newLength - 1,
                newLength); // Bottom left
        Node bottomRight = constructTree(grid, startRow + newLength, endRow, startCol + newLength, endCol,
                newLength); // Bottom right

        Node parentNode = new Node();

        if (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
            parentNode.val = topLeft.val;
            parentNode.isLeaf = true;
        } else if (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val) {
            parentNode.val = false;
            parentNode.isLeaf = true;
        } else {
            parentNode.val = topLeft.val || topRight.val || bottomLeft.val || bottomRight.val;
            parentNode.isLeaf = false;
            parentNode.topLeft = topLeft;
            parentNode.topRight = topRight;
            parentNode.bottomLeft = bottomLeft;
            parentNode.bottomRight = bottomRight;
        }

        return parentNode;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
