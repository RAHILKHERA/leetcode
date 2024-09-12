public class LeetCode_138_2 {
    public String stringHash(String s, int k) {

        StringBuilder builder = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {

            int j = i;
            int sum = 0;
            while (j < i + k) {

                sum += s.charAt(j) - 'a';
                j++;
            }

            sum %= 26;
            builder.append((char) (sum + 'a'));

            i += k;
        }

        return builder.toString();
    }
}
