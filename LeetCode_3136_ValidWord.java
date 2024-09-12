import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class LeetCode_3136_ValidWord {

    @Test
    public void test1() {

        assertFalse(isValid("UuE6"));

    }

    public boolean isValid(String word) {

        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (Character ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }

            if (!Character.isDigit(ch)) {
                if (!hasVowel) {
                    hasVowel = isVowel(ch);
                }
                if (!hasConsonant) {
                    hasConsonant = !isVowel(ch);
                }

            }
        }

        return hasConsonant && hasVowel;

    }

    private boolean isVowel(char c) {

        return "aeiouAEIOU".indexOf(c) != -1;
    }

}
