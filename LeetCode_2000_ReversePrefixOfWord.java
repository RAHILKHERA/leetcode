public class LeetCode_2000_ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {

        int pointer = word.indexOf(ch);
        // for (int i = 0; i < word.length(); i++) {
        // char character = word.charAt(i);
        // if (character == ch) {
        // pointer = i;
        // break;
        // }
        // }

        if (pointer == -1) {
            return word;
        }

        // int left = pointer, right = pointer + 1;
        // new StringBuilder(word.substring(0, pointer + 1)).reverse();

        // while (left >= 0) {
        // builder.append(word.charAt(left));
        // left--;
        // }

        // while (right < word.length()) {
        // builder.append(word.charAt(right));
        // right++;
        // }

        return new StringBuilder(word.substring(0, pointer + 1)).reverse().toString() + word.substring(pointer + 1);
    }
}
