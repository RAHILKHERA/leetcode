import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_1980_FindUniqueBinaryStrings {
    public static void main(String[] args) {
        new Solution_LeetCode_1980_FindUniqueBinaryStrings().findDifferentBinaryString(new String [] {
            "01", "10"
        });
    }
}

class Solution_LeetCode_1980_FindUniqueBinaryStrings {
    
        private static HashMap<Integer, List<String>> map;

        static {

            map = new HashMap<>();
            createBinaryString();
        }
        
        
        public String findDifferentBinaryString(String[] nums) {
            
            int n = nums.length;

            List<String> binaryStrings = map.get(n);
            
            for (String bs : binaryStrings) {
                
                boolean found = false; 

                for(String num : nums) {

                    if (bs.equals(num)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    return bs;
                }

            }
            

            return null;    
        }

        private static void createBinaryString() {

            List<String> prevResult = new ArrayList<>();
            prevResult.add("0");
            prevResult.add("1");
            map.put(1, prevResult);
            for (int i = 2; i <= 16; i++) {
                List<String> result = new ArrayList<>();    
                for (String binary : prevResult) {

                    result.add(binary + "0");
                    result.add(binary + "1");
                }
                
                map.put(i, result);
                prevResult = result;
            }
        }
}
