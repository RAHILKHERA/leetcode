import java.util.ArrayList;
import java.util.List;

public class LeetCode_119_PascalTriangle2 {

    public static void main(String[] args) {
        new Solution_LeetCode_119_PascalTriangle2().getRow(5);
    }
    
}

class Solution_LeetCode_119_PascalTriangle2 {

    private static double fact[] = new double[34];

    static {
        factorial(33);
    }

    private static double factorial (int n) {

        if (n == 0 || n == 1) {
            fact[0] = 1;
            fact[1] = 1;
            return 1;
        } 
        if (fact[n] != 0) {
            return fact[n];
         } else {
            fact[n] = n * factorial(n - 1);
            return fact[n]; 
         }
    }
    
    public List<Integer> getRow(int rowIndex) {
        
        List <Integer> result = new ArrayList<>();
        
        for (int i = 0; i <=rowIndex; i++) {
            
            int number = (int) (Math.ceil(fact[rowIndex]/(fact[i] * fact[rowIndex-i])));
            result.add(i, number);
        }
        return result;
    }
}
