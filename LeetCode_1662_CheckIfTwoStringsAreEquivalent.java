public class LeetCode_1662_CheckIfTwoStringsAreEquivalent {
    
    public static void main(String[] args) {
        new Solution_LeetCode_1662_CheckIfTwoStringsAreEquivalent().arrayStringsAreEqual(new String [] {"a", "cb" }, 
                                                                                                    new String [] {"ab", "b" });
    }
}

class Solution_LeetCode_1662_CheckIfTwoStringsAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
     
        int i = 0, j = 0, k = 0, l = 0;

        while (true) {
            
            char ch1 = word1[i].charAt(j);
            char ch2 = word2[k].charAt(l);

            if (ch1 != ch2) {
                return false;
            } else {
                j++;
                if (j == word1[i].length()) {
                    i++;
                    if (i == word1.length) {
                        break;
                    } else {
                        j = 0;
                    }
                }

                l++;

                if (l == word2[k].length()) {
                    k++;
                    if (k == word2.length) {
                        break;
                    } else {
                        l = 0;
                    }
                }
            }
        }

        if (i == word1.length && l == word2[k].length() -1 && k == word2.length -1) {
            return true;
        }
    
        return false;
    }
}

class Solution_LeetCode_1662_CheckIfTwoStringsAreEquivalent_Another {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder combined1 = new StringBuilder();
        StringBuilder combined2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            combined1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            combined2.append(word2[i]);
        }

        return combined1.toString().equals(combined2.toString());
    }
}
