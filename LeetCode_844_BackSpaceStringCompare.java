public class LeetCode_844_BackSpaceStringCompare {

    public static void main(String[] args) {
        // new
        // Solution_LeetCode_844_BackSpaceStringCompare().backspaceCompare("a#b#c#d#",
        // "klmn#####");
        new Solution_LeetCode_844_BackSpaceStringCompare().backspaceCompare("j##yc##bs#srqpfzantto###########i#mwb", "j##yc##bs#srqpf#zantto###########i#mwb");
    }
}

class Solution_LeetCode_844_BackSpaceStringCompare {
    public boolean backspaceCompare(String s, String t) {

        int skipS = 0, skipT = 0;
        int i = s.length() - 1;
        int j = t.length() - 1;
        boolean emptyS = false, emptyT = false;
        if (i == 0 && i == j) {
            return true;
        }

        while (i >= 0 && j >= 0) {
            boolean compare = false;
            char charS = s.charAt(i);
            char charT = t.charAt(j);
            if (charS == '#') {
                skipS++;
                i--;
            } else if (skipS > 0) {
                skipS--;
                i--;
            } else {
                compare = true;
            }

            if (charT == '#') {
                skipT++;
                j--;
            } else if (skipT > 0) {
                skipT--;
                j--;
            } else if (compare) {
                if (charS != charT) {
                    return false;
                } else {
                    i--;
                    j--;
                }
            }

            if (i + 1 <= skipS) {
                emptyS = true;
                break;
            }

            if (j + 1 <= skipT) {
                emptyT = true;
                break;
            }
        }

        if (emptyS) {
            while (j >= 0) {
                char charT = t.charAt(j);
                if (charT == '#') {
                    skipT++;

                } else if (skipT > 0) {
                    skipT--;

                }

                if (j == 0  && skipT <=0 && charT !='#') {
                    return false;
                }
                
                j--;
                
               
                if (j + 1 <= skipT) {
                    return true;
                }
            }
        }

        if (emptyT) {
            while (i >= 0) {
                char charS = s.charAt(i);
                if (charS == '#') {
                    skipS++;

                } else if (skipS > 0) {
                    skipS--;

                }
                
                if (i == 0  && skipS <=0 && charS != '#') {
                    return false;
                }

                i--;
                
                if (i + 1 <= skipS) {
                    return true;
                }
            }

        }

        if (i >= 0 && skipS == 0) {
            return false;
        }

        if (j >= 0 && skipT == 0) {
            return false;
        }

        return true;
    }
}
