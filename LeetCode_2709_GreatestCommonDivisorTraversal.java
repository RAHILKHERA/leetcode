import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_2709_GreatestCommonDivisorTraversal {

    private static final int MAX_NUM = 100010;
    private static final List<Integer>[] primeFactors = new List[MAX_NUM];

    // Static block for initialization of prime factor lists for numbers up to
    // MAX_NUM
    static {
        Arrays.setAll(primeFactors, x -> new ArrayList<>());
        for (int num = 1; num < MAX_NUM; ++num) {
            int temp = num;
            for (int i = 2; i <= temp / i; ++i) {
                if (temp % i == 0) {
                    primeFactors[num].add(i);
                    while (temp % i == 0) {
                        temp /= i;
                    }
                }
            }
            if (temp > 1) {
                primeFactors[num].add(temp); // Add remaining prime factor
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {

        int maxValue = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;

        // Create a UnionFind object to represent graph connectivity
        DisjointSet unionFind = new DisjointSet(n + maxValue + 1);

        // Union each number with its prime factors offset by n (to avoid index
        // collision)
        for (int i = 0; i < n; ++i) {
            for (int prime : primeFactors[nums[i]]) {
                unionFind.union(i, prime + n);
            }
        }

        // Add the root representative of each number to a set to check connectivity
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            roots.add(unionFind.find(i));
        }

        // If there is only one root, all nodes are connected
        return roots.size() == 1;

    }

    public class DisjointSet {

        private int[] parent;

        public DisjointSet(int members) {
            parent = new int[members + 1];

            /**
             * Each member is in its own set.
             * Each member is it's own parent.
             * A negative sign suggests that the index is a parent.
             * The negative value represents the number of nodes in the set.
             */
            Arrays.fill(parent, -1);
        }

        public int[] getParent() {
            return Arrays.copyOf(parent, parent.length);
        }

        public int getNumElements() {
            return parent.length;
        }

        public int getNumSets() {

            int count = 0;
            for (int i : parent) {
                if (i < 0) {
                    count++;
                }
            }
            return count;
        }

        public boolean inSameSet(int x, int y) {
            return find(x) == find(y);
        }

        /**
         * 
         * @param x
         * @return returns the representative of the set.
         */

        public int find(int x) {

            if (parent[x] < 0) {
                return x;
            }

            int root = find(parent[x]); // Find the root recursively
            int current = x;
            while (current != root) {
                int next = parent[current]; // Store the next node on the path
                parent[current] = root; // Point the current node to the root
                current = next; // Move to the next node
            }

            return root;
        }

        /**
         * Performs union between two sets x and y.
         * 
         * @param x
         * @param y
         * @return If union is performed returns true else false;
         */
        public boolean union(int x, int y) {

            int parentX = find(x);
            int parentY = find(y);

            int rankX = parent[parentX];
            int rankY = parent[parentY];

            /**
             * Update parent to merge small tree into larger one.
             * As negative sign is used to represent parent.
             * Less than sign is used to reprsent the larger tree.
             */
            if (parentX != parentY) {
                if (rankX <= rankY) {
                    parent[parentY] = parentX;
                    parent[parentX] = rankX + rankY;
                } else if (rankY < rankX) {
                    parent[parentX] = parentY;
                    parent[parentY] = rankX + rankY;
                }
                return true;
            }

            return false;
        }

        public int getRank(int x) {
            return parent[find(x)];
        }

    }
}
