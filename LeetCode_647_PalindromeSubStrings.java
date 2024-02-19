public class LeetCode_647_PalindromeSubStrings {
    public int countSubstrings(String s) {

        int count = 0;
        char[] sCharArray = s.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {

            count += countPalindroms(sCharArray, i, i);
            count += countPalindroms(sCharArray, i, i + 1);
        }

        return count;

    }

    private int countPalindroms(char[] sCharArray, int left, int right) {

        int count = 0;

        while (left >= 0 && right < sCharArray.length && sCharArray[left] == sCharArray[right]) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
