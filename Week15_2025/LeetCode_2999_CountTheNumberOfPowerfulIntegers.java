package Week15_2025;
/**
 * LeetCode Problem: 2999 Count the number of powerful integers
 * Problem Link:
 * https://leetcode.com/problems/count-the-number-of-powerful-integers/?envType=daily-question&envId=2025-04-10
 * 
 * Definition : Powerful Integer (PI) : A positive integer 'x' is called
 * powerful
 * integer if it has suffix 's' and each digit is at most 'limit'.
 * 
 * Task: Count total number of powerful integers in the range 'start' to
 * 'finish' (inclusive). Suffix 's' is valid positive integer string.
 * 
 * Observation :
 * #1 A PI can be created only when 's' is it's suffix. This means, all the
 * numbers smaller (in length) compare to suffix cannot be counted as PI.
 * #2 If x = number of PI less than start and y = number of PI less
 * than equal to finish. Total count in the range will be y - x.
 * #3 There are options to fill the places ahead of the suffix. The total count
 * of PI will be multiplication of all the options across all the positions
 * ahead of suffix. (length - suffix length).
 * #4 If the current digit is greater than limit, all the position can be filled
 * with limit + 1 values (0 to limit) => (limit + 1) ^ (prefixLength - pos).
 * #5 If the current digit is smaller than limit, that position can be filled by
 * number of options same as digit e.g. current digit is 3, then options are 0,
 * 1, 2.
 * In this case, all the positions can be filled with digit * (limit + 1) ^
 * (prefixLenth - pos - 1). -1 for the current position.
 * #6 If the suffix of the number is smaller than or equal to the given suffix,
 * we can include that number as a valid powerful integer.
 * E.g start = 15, end = 215 limit = 6 suffix = "10"
 * str = "215" suffix = "10" limit = 6.
 * suffix length = 2
 * str length = 3.
 * str suffix value = "15".
 * str suffix <= suffix => 1 more power integer.
 * For end => 010, 110, 210 all are valid. In #5 it will only consider 10 and
 * 110 as in place of 2, we consider only options 0,1.
 * But 210 is also valid as 210 all digits are less than limit (6) and it has
 * suffix "10".
 * 
 * 
 * Approach:
 * #1 count power integers <= finish. (x)
 * #2 count power integer < start.(y)
 * #3 Ans is x - y.
 * 
 * Approach to calculat powerInteger <= X.
 * #1 Find Prefix length(len). (x.length - suffix.length).
 * #2 Find suffix of x. (If this is smaller or equal to suffix, increase count
 * by 1).
 * #3 For each position (pos) of the prefix, fetch the digit and calculate the
 * count.
 * a) digit < limit => digit * (limit + 1) ^ (len - pos - 1)
 * b) digit >= limit => (limit + 1) ^ (len - pos)
 * 
 * Time Complexity: O(n log n),
 * Space Complexity: O(n) where n = length of finish,
 */

public class LeetCode_2999_CountTheNumberOfPowerfulIntegers {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String start_ = Long.toString(start - 1);
        String finish_ = Long.toString(finish);

        return calculate(finish_, s, limit) - calculate(start_, s, limit);
    }

    private long calculate(String str, String suffix, int limit) {

        if (str.length() < suffix.length())
            return 0;

        if (str.length() == suffix.length()) {
            return str.compareTo(suffix) >= 0 ? 1 : 0;
        }

        int trailLength = str.length() - suffix.length();
        String trail = str.substring(str.length() - suffix.length());
        long count = 0;

        for (int pos = 0; pos < trailLength; pos++) {
            int digit = str.charAt(pos) - '0';
            if (digit > limit) {
                count += (long) Math.pow(limit + 1, trailLength - pos);
                return count;
            } else {
                count += (long) digit * (long) Math.pow(limit + 1, trailLength - pos - 1);
            }
        }

        if (trail.compareTo(suffix) >= 0)
            count++;
        return count;
    }
}