import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class LeetCode_2385_AmountOfTimeForBinaryTreeToBeInfected {

    @Test
    public void test1() {

        TreeNode node1 = new TreeNode(1);

        assertEquals(0, amountOfTime(node1, 1));

    }

    @Test
    public void test2() {

        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4, node9, node2);
        TreeNode node5 = new TreeNode(5, null, node4);

        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, node10, node6);

        TreeNode node1 = new TreeNode(1, node5, node3);

        assertEquals(4, amountOfTime(node1, 3));

    }

    @Test
    public void test3() {

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, node4, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);

        assertEquals(3, amountOfTime(node1, 4));

    }

    @Test
    public void test4() {

        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4, node1, null);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, node2, node3);
        assertEquals(3, amountOfTime(node5, 4));

    }

    @Test
    public void test5() {

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, node4, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);

        assertEquals(4, amountOfTime(node1, 5));

    }

    @Test
    public void test6() {

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, node4, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);

        assertEquals(2, amountOfTime(node1, 3));

    }

    @Test
    public void test7() {

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, node4, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);

        assertEquals(3, amountOfTime(node1, 4));

    }

    @Test
    public void test8() {

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4, node5, null);
        TreeNode node3 = new TreeNode(3, node4, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, node2, null);

        assertEquals(3, amountOfTime(node1, 2));

    }

    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        convert(root, 0, adjacencyList);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int minute = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int node = queue.poll();
                visited.add(node);
                for (Integer neighbor : adjacencyList.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
                levelSize--;
            }
            minute++;
        }

        return minute - 1;
    }

    private void convert(TreeNode node, int parent, Map<Integer, Set<Integer>> adjacencyList) {

        if (node == null) {
            return;
        }

        adjacencyList.computeIfAbsent(node.val, key -> new HashSet<>());

        Set<Integer> neighbors = adjacencyList.get(node.val);
        if (parent != 0) {
            neighbors.add(parent);
        }

        if (node.left != null) {
            neighbors.add(node.left.val);
        }

        if (node.right != null) {
            neighbors.add(node.right.val);
        }

        convert(node.left, node.val, adjacencyList);
        convert(node.right, node.val, adjacencyList);
    }
}
