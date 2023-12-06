public class LeetCode_1759_CountNumberOfHomenousStrings {

    public static void main(String[] args) {
        new Solutioin_LeetCode_1759_CountNumberOfHomenousStrings().countHomogenous("xy");
    }
    
}

class Solutioin_LeetCode_1759_CountNumberOfHomenousStrings {
    public int countHomogenous(String s) {
        int count = 0;
        int  i = 0, j = 0; 
        while (i < s.length()) {
            int current_count = 0;
            char chI = s.charAt(i);            
            while (j < s.length()) {
                char chJ = s.charAt(j);
                if (chI == chJ) {
                    current_count++;
                    j++;
                } else {
                    break;
                }
            }
            current_count = current_count % 1000000007;
            count = (count + ((current_count * (current_count + 1)) / 2));
            i = j;
        }
        return count;
    }
}
