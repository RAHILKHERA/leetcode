package Week18_2025;

/**
 * LeetCode Problem: 2071 Maximum number of tasks you can assign. 
 * Problem Link: https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/?envType=daily-question&envId=2025-05-01
 *
 * Input : 
 *  - Integer array tasks, where tasks[i] = strength required to complete i task. 
 *  - Integer array workers, where worker[j] = strength of worker to complete j task. 
 *  - Integer pills = strength increasing pills. 
 *  - Integer strength = Taking pill increases strength of the worker by 'strength'.
 * 
 * Constraints:
 * n == tasks.length
 * m == workers.length
 * 1 <= n, m <= 5 * 10^4
 * 0 <= pills <= m
 * 0 <= tasks[i], workers[j], strength <= 10^9
 * 
 * 
 * Definition : 
 *  - To perform a task, the strength of the worker must be greater than equal to the strength required to complete the task. 
 *  - Pill increases the strength of the worker, but each worker can receive only one pill. 
 *  - Each worker can only be assigned one task.  
 * 
 * Task:
 * Maximize the number of tasks that can be assigned. 
 *
 * Observations:
 * #1. Task can be assigned in following conditions
 *  => if the current strength of the worker is greater than equal to the strength required to perfom the task. 
 *  => if pills are available and each pills gives strength such that total strength of worker becomes greater than equal to that required for the task. 
 *  => workers[j] >= tasks[i] or workers[j] + strength >= tasks[i].
 * 
 * #2. Starting with the weakest tasks could be useful as it decreases the probablity of using the pills.
 *     First Trial : 
 *      i) Start with the weakest tasks, and try to find worker to assign it, if not assignable try to use pill, if still not assignable move to the worker with higher strength.
 *      ii) Instead of checking each worker, use binary search so sort the workers array too. 
 *      iii) Also maintain the boolean array to mark if the worker is already asssigned. 
 *      iv) If task was assigned, try to find the least strength worker to perform the task. 
 *      Conclusion : This fails, as it never considers assigning pill to lower strength worker. (Test case #4)
 *      
 *     Second Trial : 
 *      i) Same as first trial only change is first try to find worker without pill. if search fails, try with pill. 
 *      Conclusion : This fails too for the same reasons first trial failed. 
 * 
 * #3. Instead of trying to assign worker to each task, try to answer how many task are possible to assign?
 *    => In worst case, 0 tasks will be assigned. 
 *    => In best case, minimum of tasks and worker will be assigned. (Each worker can be assigned maximum of 1 task).
 *    => So the possible answer is in range from 0 to n. 
 *    => As there is a fixed range, here binary search over the answers can be used. 
 *    => Try if x tasks can be assigned, if yes, increase it and try if no reduce the x and try. 
 * 
 * #4. Check if the x tasks can be assigned.
 *  => x tasks need to assigned. So, x workers are required. 
 *  => Try to assign the x strongest workers to the x weakest tasks. 
 *  => Duplicate strengths are allowed, hence strengths of workers must be grouped and their frequency must be maintained. 
 *  => Strongest worker is required, so the sorting of the unique worker strengths is required. 
 *  => TreeMap will be suitable as it will keep count of strength vs frequency and also keep the strengths in the sorted order. 
 *  => If given task strength is less than equal to the strogest worker, than it can be done, and as every worker can be assigned only one task, the frequencey needs to be reduced by one. 
 *  => If given task strength is greater than strongest worker, it cannot be perform by any worker without using pills. 
 *  => If pills are available, need to find the worker whose current strength(w) + strength(s) >= task's strength.(t)
 *  => w >= t - s. Hence pill can be consumed by all the workers whose strength satisfies the equation. 
 *  => Best case, if the weakest worker can perform the toughest task after taking the pill. 
 *  => Find the least worker strength greater than equal to (t - s).
 *  => If cannot find then worker, x tasks cannot be assigned. 
 * 
 *  #5. Passing all data as parameters would increase memory usage and slow down context switching. Keeping the method signature minimal helps with efficiency and readability.
 * 
 *  #6. Since range is always from 1 to min(n, m), there will always be at least one valid key when retrieving the strongest valid assignment—no need to handle the zero case.
 * 
 *  #7. Before determining the feasibility of assigning a pill, we first add strength values. This ensures correct comparisons during greedy allocation
 * 
 * 
 * Approach:
 * 1. Sort tasks and workers. 
 * 2. Implement the binary search over possible answer that is number of tasks possible to be assigned. 
 * 3. Range of binary search from 1 to min(n, m).
 * 4. For each number of tasks,
 *     => Maintain tree map for strongest workers (strength vs count), as duplicate strengths can occur i.e. workers with same strength and each worker can be assigned only one task.
 *     => If task is assigned, reduce the count of the strength of worker, if zero, remove the strength. 
 *     => If strongest worker's strength >= task's strength => update the map. 
 *     => Else pills need to be consumed,  if pills are not available, tasks cannot be assigned. 
 *     => If pills available, then find the weakest worker with strength such that strength >= task's strength - pill strength.  
 *     => If worker is available, assign it else return. 
 * Time Complexity: O(n log n) +  O(m log m) + O (min(n,m) log^2(min(m,n)))
 *     => Sorting tasks - O(n log n), n = number of tasks.
 *     => Sorting workers - O(m log m), m = number of workers. 
 *     => Binary Search - Upper bound = min(n,m)
 *                      - Genral is binary search complixy = (x log x)
 *        -But here the search involved operations over tree map, which has complexity of log(y).
 *        -As this upper bounded by min(n,m) log(y) = log(min(n,m)) and x = min(n,m)
 *        - Binary Search Complexity = O (min(n,m) log^2(min(m,n)))
 *     => Final Complexity :  O(n log n) +  O(m log m) + O (min(n,m) log^2(min(m,n)))
 *  
 * Space Complexity: O(log n) + O (log m) + O(min (n, m))
 *      - Sorting tasks - O(log n),
 *      - Sorting workers - O(log m)
 *      - Tree Map  O(min (n, m))
 *      - Final Complexity = O(log n) + O (log m) + O(min (n, m)).
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.TreeMap;

import org.junit.Test;

public class LeetCode_2071_MaximumNumberOfTasksYouCanAssign {

    @Test
    public void test1() {
        assertEquals(3, maxTaskAssign(new int[] { 3, 2, 1 }, new int[] { 0, 3, 3 }, 1, 1));
    }

    @Test
    public void test2() {
        assertEquals(1, maxTaskAssign(new int[] { 5, 4 }, new int[] { 0, 0, 0 }, 1, 5));
    }

    @Test
    public void test3() {
        assertEquals(2, maxTaskAssign(new int[] { 10, 15, 30 }, new int[] { 0, 10, 10, 10, 10 }, 3, 10));
    }

    @Test
    public void test4() {
        assertEquals(3, maxTaskAssign(new int[] { 5, 9, 8, 5, 9 }, new int[] { 1, 6, 4, 2, 6 }, 1, 5));
    }

    @Test
    public void test5() {
        assertEquals(1, maxTaskAssign(new int[] { 74, 41, 64, 20, 28, 52, 30, 4, 4, 63 }, new int[] { 38 }, 0, 68));
    }

    private int[] tasks;
    private int[] workers;
    private int pills;
    private int strength;
    private int n;
    private int m;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        this.tasks = tasks;
        this.workers = workers;
        this.pills = pills;
        this.strength = strength;
        n = tasks.length;
        m = workers.length;
        int count = 0;
        int left = 1, right = Math.min(n, m);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                count = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }

    private boolean check(int mid) {

        // Prefering Tree map over set, as there are duplicate values.
        // In case the current strongest worker cannot perform the task.
        // Pills need to be used. Question : Whom should be the pill given?
        // Best case if the pill is given to the weakest worker and that worker can
        // perform the task.

        TreeMap<Integer, Integer> strongestWorkers = new TreeMap<>();
        int remainingPills = pills;
        // Take the strongest workers
        for (int i = m - mid; i < m; i++) {
            strongestWorkers.compute(workers[i], (key, value) -> value == null ? 1 : value + 1);
        }

        // Take the weakest tasks, and try to match it with the strogest workers
        // available.
        for (int i = mid - 1; i >= 0; i--) {

            Integer strongestWorker = strongestWorkers.lastKey();
            if (strongestWorker >= tasks[i]) { // strogest worker can do this toughest task.
                strongestWorkers.compute(strongestWorker, (key, value) -> value == 1 ? null : value - 1);
            } else { // Find the weakest worker who can have the pill and perform the task.

                if (remainingPills == 0) {
                    return false;
                }
                /**
                 * WeakestWorkerStrength (x) + Strength (s) >= Tasks's Strength(t);
                 * => x + s >= t
                 * => x >= t - s
                 */
                Integer weakestWorker = strongestWorkers.ceilingKey(tasks[i] - strength);
                if (weakestWorker == null) {
                    return false;
                }
                strongestWorkers.compute(weakestWorker, (key, value) -> value == 1 ? null : value - 1);
                remainingPills--;
            }
        }

        return true;
    }
}