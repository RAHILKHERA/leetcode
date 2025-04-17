package Week16_2025;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * LeetCode Problem:2176 Count equal and divisible pairs in array.
 * Problem Link:
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/?envType=daily-question&envId=2025-04-17
 * 
 * Definitions :
 * #1 Pairs : (i,j)
 * a) 0 <= i < j < n.
 * b) nums[i] == nums[j].
 * c) (i * j) % k == 0.
 * 
 * Task : Count number of pairs for given array nums and integer k.
 * 
 * Observation :
 * #1 Constraints are low, so brute force apporach will work fine. But it's
 * complexity would be O(n^2).
 * #2 Both the elements should have equal value. Hence a map of element vs list
 * of indices will help in avoiding check of nums[i] == nums[j].
 * #3 As list of indices, correspond to single value, only required condition to
 * check is (i * j) % k == 0 satisfies.
 * #4 From Number theroy, To satisfy (i * j) % k = 0. If i and k are know, then
 * factor of j = k / gcd(k, i).
 * 
 * For e.g. i = 4 and k = 6.
 * Factors i = 2 * 2, k = 2 * 3
 * Greatest Common Factor (GCF) of 4,6 = 2.
 * Hence, 2 is the common factor, so to make (i * j ) % k = 0, j should be
 * factor of 3.
 * #5 For each factor of J, can be paired with indices who had same factor with
 * K.
 * 
 * Approach:
 * 1) Create a map of element Vs list of indices.
 * 2) Create a list of diviors of k. This will be helpful to calculate the
 * common factors of the index and the k.
 * 3) For each index in each list of indexes, do the following
 * a) maintain another map factor vs frequency.
 * b) find the common factor requried using k/gcd(k, index).
 * c) from factor vs frequency map, find out how many indexes with same common
 * factor were processed. This will be added to the final result, as this
 * frequency represents number of indices with which current index can be
 * paired.
 * d) For the current index, add all its common factor with K to the factor vs
 * frequency map. This is for future use.
 * 
 * Time Complexity: O(n + n sqrt(k) + n log k). where n = length of the array.
 * Space Complexity: O(n + sqrt(k)).
 */
public class LeetCode_2176_CountEqualAndDivisiblePairsInArray {

    @Test
    public void test1() {
        assertEquals(4, countPairs(new int[] { 3, 1, 2, 2, 2, 1, 3 }, 2));
    }

    @Test
    public void test2() {
        assertEquals(0, countPairs(new int[] { 1, 2, 3, 4 }, 1));
    }

    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int idx = 0; idx < n; idx++) {
            map.computeIfAbsent(nums[idx], key -> new ArrayList<>()).add(idx);
        }

        List<Integer> divisors = new ArrayList<>();
        for (int divisor = 1; divisor * divisor <= k; divisor++) {
            if (k % divisor == 0) {
                divisors.add(divisor);
                if (divisor != k / divisor) {
                    divisors.add(k / divisor);
                }
            }
        }

        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Map<Integer, Integer> factorFreqMap = new HashMap<>();
            for (int index : entry.getValue()) {
                int factorOfJ = k / gcd(k, index);
                // Fetch number of indicies seen in past with same factor. All those indices can
                // be paired with current index due to common factor.
                count += factorFreqMap.getOrDefault(factorOfJ, 0);

                // Add factor common between current index and that of K to the map. For future
                // use.
                for (int divisor : divisors) {
                    if (index % divisor == 0) {
                        int freq = factorFreqMap.getOrDefault(divisor, 0);
                        freq++;
                        factorFreqMap.put(divisor, freq);
                    }
                }

            }
        }
        return count;
    }

    private int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}