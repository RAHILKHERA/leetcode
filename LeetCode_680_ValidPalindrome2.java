import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LeetCode_680_ValidPalindrome2 {

    @Test
    public void test1() {

        assertTrue(validPalindrome("aba"));
    }

    @Test
    public void test2() {

        assertTrue(validPalindrome("abca"));
    }

    @Test
    public void test3() {

        assertFalse(validPalindrome("abc"));
    }

    @Test
    public void test4() {

        assertTrue(validPalindrome("deddde"));
    }

    @Test
    public void test5() {

        assertTrue(validPalindrome("cbbcc"));
    }

    public boolean validPalindrome(String s) {

        return false;
    }

    /**
     * This function test wheter the string is palindrome or not.
     * If it is palindrome it will return -1,-1. else it will return the indexes
     * where the character mismatch happened.
     * 
     * @param s
     * @return
     */
    private int[] isPalindrome(String s, int start, int end) {

        return new int[] { -1, -1 };
    }
}
