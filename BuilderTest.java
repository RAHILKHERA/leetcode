public class BuilderTest {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder("))((");
        int i = 0;

        while (i < builder.length()) {
            char ch = builder.charAt(i);
            if (ch == ')') {
                builder.deleteCharAt(i);
            } else {
                i++;
            }
        }

        i = builder.length() - 1;
        while (i >= 0) {
            char ch = builder.charAt(i);
            if (ch == '(') {
                builder.deleteCharAt(i);
            }

        }
        System.out.println(builder.toString());
    }
}
