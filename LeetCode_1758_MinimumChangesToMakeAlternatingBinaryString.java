public class LeetCode_1758_MinimumChangesToMakeAlternatingBinaryString {

    public static void main(String[] args) {
        new LeetCode_1758_MinimumChangesToMakeAlternatingBinaryString().minOperations("0100");
    }

    public int minOperations(String s) {

        char ch = s.charAt(0);
        int count1 = changesRequired(s, ch);
        int count2 = changesRequired(s, ch == '0' ? '1' : '0') + 1;

        return Math.min(count1, count2);
    }

    private int changesRequired(String s, char previousChar) {

        int changesRequired = 0;

        for (int i = 1; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            if (previousChar == currentChar) {
                changesRequired++;
                previousChar = previousChar == '0' ? '1' : '0';
            } else {
                previousChar = currentChar;
            }
        }

        return changesRequired;
    }
}
