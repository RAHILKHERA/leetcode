public class LeetCode_383_RansomeNote {

    public static void main(String[] args) {
        System.out.println(new Solution_LeetCode_383_RansomeNote().canConstruct("a", "b"));
        System.out.println(new Solution_LeetCode_383_RansomeNote().canConstruct("aa", "ab"));
        System.out.println(new Solution_LeetCode_383_RansomeNote().canConstruct("aa", "aab"));
    }
}

class Solution_LeetCode_383_RansomeNote {

    public boolean canConstruct (String ransomNote, String magazine) {

        if (ransomNote.isBlank()) {
            return true;
        }

        if (ransomNote.length() > magazine.length()) {
            return false;
        }


        int [] map = new int [26];

        for (int i = 0; i < magazine.length(); i++) {
            
            char ch = magazine.charAt(i);
            int index = ch - 'a';
            map[index]++;    
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int index = ch - 'a';
            map[index]--;
            if (map[index] == -1) {
                   return false;                
            }
        }

        return true;
    }
}