public class PerformanceTest {
    public static void main(String[] args) {
        int testNumber = 123456789;
        int iterations = 100000000;

        // Test Bitwise AND
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            isOddUsingBitwise(testNumber);
        }
        long endTime = System.nanoTime();
        System.out.println("Bitwise AND: " + (endTime - startTime) + " ns");

        // Test Modulo
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            isOddUsingModulo(testNumber);
        }
        endTime = System.nanoTime();
        System.out.println("Modulo: " + (endTime - startTime) + " ns");
    }

    public static boolean isOddUsingBitwise(int number) {
        return (number & 1) != 0;
    }

    public static boolean isOddUsingModulo(int number) {
        return (number % 2) != 0;
    }
}
