import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_1971_FindInPathExistsInGraph {

    private int[] parent;

    @Test
    public void test1() {

        assertFalse(validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }

        return find(source) == find(destination);
    }

    private int find(int x) {
        int root = x;
        while (parent[root] >= 0) {
            root = parent[root];
        }

        // Path compression
        int current = x;
        while (current != root) {
            int next = parent[current];
            parent[current] = root;
            current = next;
        }
        return root;

    }

    private void union(int x, int y) {

        int parentX = find(x);
        int parentY = find(y);

        if (find(x) != find(y)) {

            parent[parentY] = parentX;

        }

    }
}
