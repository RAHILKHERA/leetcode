public class LeetCode_67_AddBinary {
    
}

class Solution_LeetCode_67_AddBinary {
    public String addBinary(String a, String b) {
        
        StringBuilder result = new StringBuilder();
        
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        boolean carry = false;
        char one = '1';
        char zero = '0';

        while (indexA >=0 && indexB >=0) {
            
            char chA = a.charAt(indexA);
            char chB = b.charAt(indexB);

           if (chA == zero && chB == zero) {
                if (carry) {
                    result.append(one);
                } else {
                    result.append(zero);
                }
                carry = false;
           } else if ((chA == zero && chB == one) || (chA == one && chB == zero)) {
                if (carry) {
                    result.append(zero);
                } else {
                    result.append(one);
                }
           } else {
                if (carry) {
                    result.append(one);
                } else {
                    result.append(zero);
                } 
                carry = true;
           }

           indexA--;
           indexB--;
        }

        while (indexA >=0) {

            char chA = a.charAt(indexA);
            if (carry) {
                if (chA == zero) {
                    result.append(one);
                    carry = false;
                } else {
                    result.append(zero);
                }
            } else {
                result.append(chA);
            }
            indexA--;
        }   
        
        while (indexB >=0) {
            char chB = b.charAt(indexB);
            if (carry) {
                if (chB == zero) {
                    result.append(one);
                    carry = false;
                } else {
                    result.append(zero);
                }
            } else {
                result.append(chB);
            }
            indexB--;
        }

        if (carry) {
            result.append(one);
        }

        return result.reverse().toString();
    }
}