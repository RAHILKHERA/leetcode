public class LeetCode_3146_PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {

            count[s.charAt(i) - 'a'] += i;
            count[t.charAt(i) - 'a'] -= i;
        }

        int pd = 0;

        for (int i = 0; i < count.length; i++) {
            pd += Math.abs(count[i]);
        }

        return pd;

    }
}
