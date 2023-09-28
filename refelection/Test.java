package refelection;

public class Test {
    public static void main(String[] args) {
        new Test();
    }

    Test() {
        show();
    }

    private void show () {
        System.out.println("In Show");
    }
}
