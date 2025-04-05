import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class MinimumCostWalkInWeightedGraph {

    @Test
    public void test1() {
        assertArrayEquals(new int[] { 1, -1 },
                minimumCost(5, new int[][] { { 0, 1, 7 }, { 1, 3, 7 }, { 1, 2, 1 } },
                        new int[][] { { 0, 3 }, { 3, 4 } }));
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        Disjoint disjoint = new Disjoint(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            disjoint.union(u, v, weight);
        }

        int q = query.length;
        int[] result = new int[q];
        for (int idx = 0; idx < q; idx++) {
            int u = query[idx][0];
            int v = query[idx][1];
            result[idx] = disjoint.inSameGroup(u, v);
        }
        return result;
    }

    private class Disjoint {

        private int[] parent;
        private int[] values;

        Disjoint(int members) {

            parent = new int[members];
            values = new int[members];
            Arrays.fill(parent, -1);
            Arrays.fill(values, -1);
        }

        int find(int x) {

            // If parent is negative, they are in their own group/ element is the leader of
            // the group.
            if (parent[x] < 0) {
                return x;
            }

            int root = find(parent[x]);

            // Flatening of the tree.
            int current = x;
            while (current != root) {
                int next = parent[current];
                parent[current] = root;
                current = next;
            }
            return root;
        }

        void union(int u, int v, int weight) {

            int parentU = find(u);
            int parentV = find(v);

            if (parentU == parentV) {
                return;
            }

            int rankU = parent[parentU];
            int rankV = parent[parentV];

            if (rankU <= rankV) { // parents are represneted as negative number hence rankU <= rankV ==> rankU is
                                  // of bigger size
                parent[parentV] = parentU;
                parent[parentU] = rankU + rankV;
                if (values[parentU] == -1) {
                    values[parentU] = weight;
                } else {
                    values[parentU] &= weight;
                }
            } else {
                parent[parentU] = parentV;
                parent[parentV] = rankU + rankV;
                if (values[parentV] == -1) {
                    values[parentV] = weight;
                } else {
                    values[parentV] &= weight;
                }
            }
        }

        int inSameGroup(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);
            if (parentU == parentV) {
                return values[parentU];
            }
            return -1;
        }
    }
}
