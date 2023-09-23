import java.util.HashMap;

public class LeetCode_205_IsomorphicStrings {
    public static void main(String[] args) {
         boolean  isomorphic = new Solution_LeetCode_205_IsomorphicStrings().isIsomorphic("foo", "bba");
         System.out.println(isomorphic);
         
    }    
}

class Solution_LeetCode_205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0 ; i < s.length(); i++) {
            
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false; 
                }
            } else {
                map.put(ch1, ch2);
            }   

        }
        return true;
    }
}
