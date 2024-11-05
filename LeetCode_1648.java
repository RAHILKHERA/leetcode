public class LeetCode_1648 {

    public int countConsistentStrings(String allowed, String[] words) {

        int count = 0;
        int mask = 0;

        for (char ch : allowed.toCharArray()) {
            mask |= (1 << (ch - 'a'));
        }

        for (String word : words) {
            if (isConsistent(word, mask)) {
                count++;
            }
        }

        return count;
    }

    private boolean isConsistent(String word, int mask) {

        for (int i = 0; i < word.length(); i++) {

            if ((mask >> (word.charAt(i)) & 1) != 1) {
                return false;
            }
        }

        return true;
    }

}
