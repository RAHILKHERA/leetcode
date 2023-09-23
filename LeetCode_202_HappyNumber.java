import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_202_HappyNumber {
    public static void main(String[] args) {
        System.out.println("Running Tests...");
        assertTrue(new Solution_LeetCode_202_HappyNumber().isHappy(19));
        assertFalse(new Solution_LeetCode_202_HappyNumber().isHappy(2));
        assertFalse(new Solution_LeetCode_202_HappyNumber().isHappy(3));
        assertFalse(new Solution_LeetCode_202_HappyNumber().isHappy(4));
        assertFalse(new Solution_LeetCode_202_HappyNumber().isHappy(5));
        assertFalse(new Solution_LeetCode_202_HappyNumber().isHappy(6));
        assertTrue(new Solution_LeetCode_202_HappyNumber().isHappy(7));
        assertFalse(new Solution_LeetCode_202_HappyNumber().isHappy(8));
        assertFalse(new Solution_LeetCode_202_HappyNumber().isHappy(9));
        System.out.println("Passed All Test Case");
    }
}

class Solution_LeetCode_202_HappyNumber {

    private static HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

    static {
        map.put(1, true);
    }

    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<Integer>();
        int saveI = n;

        if (!map.containsKey(n)) {

            while (true) {

                int sum = findSquareSum(saveI);
                if (sum == 1) {
                    map.put(n, true);
                    for (int j : set) {
                        map.put(j, true);
                    }
                    break;
                } else if (map.containsKey(sum)) {
                    boolean value = map.get(sum);
                    map.put(n, value);
                    for (int j : set) {
                        map.put(j, value);
                    }
                    break;
                } else if (set.contains(sum)) {
                    map.put(n, false);
                    for (int j : set) {
                        map.put(j, false);
                    }
                    break;
                }
                saveI = sum;
                set.add(sum);
            }
        }

        return map.get((Integer) n);
    }

    private static int findSquareSum(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
