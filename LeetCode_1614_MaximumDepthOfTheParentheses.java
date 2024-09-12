public class LeetCode_1614_MaximumDepthOfTheParentheses {
    public int maxDepth(String s) {

        int maxDepth = 0, count = 0;

        for (Character c : s.toCharArray()) {

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            maxDepth = maxDepth > count ? maxDepth : count;
        }

        return maxDepth;
    }
}
