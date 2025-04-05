import java.util.Arrays;
import java.util.function.IntPredicate;

public class MaximumCountOfPositiveAndNegativeInteger {

    public int maximumCount(int[] nums) {

        IntPredicate lambdaP = num -> num > 0;
        IntPredicate lambdaN = num -> num < 0;
        int pos = (int) Arrays.stream(nums).filter(lambdaP).count();
        int neg = (int) Arrays.stream(nums).filter(lambdaN).count();
        return Math.max(pos, neg);
    }
}