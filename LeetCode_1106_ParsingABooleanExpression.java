import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LeetCode_1106_ParsingABooleanExpression {

    @Test
    public void test1() {
        assertFalse(parseBoolExpr("&(|(f))"));
    }

    @Test
    public void test2() {
        assertTrue(parseBoolExpr("|(f,f,f,t)"));
    }

    @Test
    public void test3() {
        assertTrue(parseBoolExpr("!(&(f,t))"));
    }

    @Test
    public void test4() {
        assertFalse(parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    @Test
    public void test5() {
        assertTrue(parseBoolExpr("|(f,&(t,t))"));
    }

    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        return parse(expression, 0, n - 1);
    }

    private boolean parse(String s, int left, int right) {

        boolean result = false;
        if (s.charAt(left) == '|') {
            while (right >= 0 && s.charAt(right) != ')')
                right--;
            result = parse_or(s, left + 1, right);
        } else if (s.charAt(left) == '&') {
            while (right >= 0 && s.charAt(right) != ')')
                right--;
            result = parse_and(s, left + 1, right);
        } else if (s.charAt(left) == '!') {
            while (right >= 0 && s.charAt(right) != ')')
                right--;
            result = parse_not(s, left + 1, right);
        }

        return result;
    }

    private boolean parse_or(String s, int left, int right) {
        boolean result = false;
        while (left < right) {
            if (s.charAt(left) == 'f' || s.charAt(left) == 't') {
                result |= s.charAt(left) == 't';
                left++;
            } else if (s.charAt(left) == '&') {
                int nextClosing = s.indexOf(")", left);
                result |= parse_and(s, left + 1, nextClosing);
                left = nextClosing;
            } else if (s.charAt(left) == '|') {
                int nextClosing = s.indexOf(")", left);
                result |= parse_or(s, left + 1, s.indexOf(")", nextClosing));
                left = nextClosing;
            } else if (s.charAt(left) == '!') {
                int nextClosing = s.indexOf(")", left);
                result |= parse_not(s, left + 1, s.indexOf(")", nextClosing));
                left = nextClosing;
            } else {
                left++;
            }
        }
        return result;
    }

    private boolean parse_and(String s, int left, int right) {
        boolean result = true;
        while (left < right) {
            if (s.charAt(left) == 'f' || s.charAt(left) == 't') {
                result &= s.charAt(left) == 't';
                left++;
            } else if (s.charAt(left) == '&') {
                int nextClosing = s.indexOf(")", left);
                result &= parse_and(s, left + 1, nextClosing);
                left = nextClosing;
            } else if (s.charAt(left) == '|') {
                int nextClosing = s.indexOf(")", left);
                result &= parse_or(s, left + 1, s.indexOf(")", nextClosing));
                left = nextClosing;
            } else if (s.charAt(left) == '!') {
                int nextClosing = s.indexOf(")", left);
                result &= parse_not(s, left + 1, s.indexOf(")", nextClosing));
                left = nextClosing;
            } else {
                left++;
            }
        }
        return result;
    }

    private boolean parse_not(String s, int left, int right) {
        boolean result = false;
        while (left < right) {
            if (s.charAt(left) == 'f' || s.charAt(left) == 't') {
                return (s.charAt(left) != 't');
            } else if (s.charAt(left) == '&') {
                int nextClosing = s.indexOf(")", left);
                result = !parse_and(s, left + 1, nextClosing);
                left = nextClosing;
            } else if (s.charAt(left) == '|') {
                int nextClosing = s.indexOf(")", left);
                result = !parse_or(s, left + 1, s.indexOf(")", nextClosing));
                left = nextClosing;
            } else if (s.charAt(left) == '!') {
                int nextClosing = s.indexOf(")", left);
                result = !parse_not(s, left + 1, s.indexOf(")", nextClosing));
                left = nextClosing;
            } else {
                left++;
            }

        }
        return result;
    }
}
