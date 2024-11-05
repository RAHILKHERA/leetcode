import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeetCode_2696 {

    @Test
    public void test1() {
        assertEquals(2, minLength("ABFCACDB"));
    }

    @Test
    public void test2() {
        assertEquals(5, minLength("ACBBD"));
    }

    public int minLength(String s) {

        int n = s.length();
        Stack stack = new Stack(n);

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {

                switch (ch) {

                    case 'B':
                        if (stack.top() == 'A') {
                            stack.pop();
                        } else {
                            stack.push(ch);
                        }
                        break;
                    case 'D':
                        if (stack.top() == 'C') {
                            stack.pop();
                        } else {
                            stack.push(ch);
                        }
                        break;
                    default:
                        stack.push(ch);
                }

            }
        }

        return stack.length();
    }

    class Stack {

        private int size;
        private char[] ch;

        Stack(int n) {
            ch = new char[n];
            size = 0;
        }

        public void push(char c) {
            ch[size++] = c;
        }

        public char pop() {
            return ch[size--];
        }

        public char top() {
            return ch[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int length() {
            return size;
        }

    }
}
