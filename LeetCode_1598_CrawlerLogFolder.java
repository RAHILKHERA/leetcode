public class LeetCode_1598_CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int steps = 0;

        for (String log : logs) {

            if (log.charAt(1) == '.') {

                if (steps > 0) {
                    steps--;
                }

            } else if (log.charAt(1) != '/') {
                steps++;
            }
        }

        return steps;
    }
}
