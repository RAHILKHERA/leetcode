public class LeetCode_2864_MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        int countOnes = 0;

        for (char c : charArray) {
            if (c == '1') {
                countOnes++;
            }
        }

        for (int i = 0; i < charArray.length - 1; i++) {

            if (countOnes > 1) {
                builder.append('1');
                countOnes--;
            } else {
                builder.append('0');
            }
        }
        builder.append('1');
        return builder.toString();
    }
}
