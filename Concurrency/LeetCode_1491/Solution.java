package Concurrency.LeetCode_1491;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class Solution {

    public static void main(String args[]) throws InterruptedException, ExecutionException {

        Solution sol = new Solution();
        int[] salary = { 48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000, 33000,
                28000, 4000, 54000, 67000, 6000, 1000, 11000 };
        double avgSalary = sol.average(salary);
        System.out.println(avgSalary);
    }

    @Test
    public void test1() {
        assertEquals(2500, average(new int[] { 4000, 3000, 1000, 2000 }), 0);
    }

    public double average(int[] salary) {

        Callable<Integer> minCallable = new MinimumSalary(salary);
        Callable<Integer> maxCallable = new MaximumSalary(salary);
        Callable<Integer> sumCallable = new SumSalary(salary);

        FutureTask<Integer> minFuture = new FutureTask<>(minCallable);
        FutureTask<Integer> maxFuture = new FutureTask<>(maxCallable);
        FutureTask<Integer> sumFuture = new FutureTask<>(sumCallable);

        Thread minThread = new Thread(minFuture);
        Thread maxThread = new Thread(maxFuture);
        Thread sumThread = new Thread(sumFuture);

        minThread.start();
        maxThread.start();
        sumThread.start();

        double average = 0.0;
        try {
            minThread.join();
            maxThread.join();
            sumThread.join();

            int sum = sumFuture.get();
            int min = minFuture.get();
            int max = maxFuture.get();

            int remainingSalary = sum - min - max;

            average = (double) remainingSalary / (salary.length - 2);

        } catch (Exception e) {
            e.getStackTrace();
        }
        return average;
    }
}

class MinimumSalary implements Callable<Integer> {

    private int[] salary;

    public MinimumSalary(int[] salaray) {
        this.salary = salaray;
    }

    @Override
    public Integer call() throws Exception {
        int min = salary[0];
        for (int sal : salary) {
            if (sal < min) {
                min = sal;
            }
        }
        return min;
    }

}

class MaximumSalary implements Callable<Integer> {

    private int[] salary;

    public MaximumSalary(int[] salaray) {
        this.salary = salaray;
    }

    @Override
    public Integer call() throws Exception {
        int max = 0;
        for (int sal : salary) {
            if (sal > max) {
                max = sal;
            }
        }
        return max;
    }

}

class SumSalary implements Callable<Integer> {

    private int[] salary;

    public SumSalary(int[] salaray) {
        this.salary = salaray;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int sal : salary) {
            sum += sal;
        }
        return sum;
    }

}