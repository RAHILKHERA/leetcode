import java.util.Arrays;

public class LeetCode_135_Candy {
    public static void main(String[] args) {
        int [] ratings = {0,1,3,2};
        System.out.println(new Solution_LeetCode_135_Candy().candy(ratings));
        
    }
}

class Solution_LeetCode_135_Candy {

    public int candy(int[] ratings) {
        
        int candyPerChild [] = new int [ratings.length];
        int candies = 0;
        
        Arrays.fill(candyPerChild, 1);

        for (int i = 0; i < ratings.length; ) {

            int lnc = 0;
            int rnc = 0;
            boolean isModified = false;

            if ( i > 0 && ratings[i] > ratings[i - 1] && candyPerChild[i] <= candyPerChild[i-1]) {
                lnc = candyPerChild[i-1];
                isModified = true;
            }

            if ( i <= ratings.length - 2 && ratings[i] > ratings[i+1] && candyPerChild[i] <= candyPerChild[i+1]) {
                rnc = candyPerChild[i+1];
                isModified = true;
            }

            if(isModified) {
                candyPerChild[i] = lnc > rnc ? (lnc + 1) : (rnc + 1);
                i--;
                if (i < 0) {
                    i = 0;
                }
            } else {
                i++;
            }

        }

        for (int candy : candyPerChild) {
            candies += candy;
        }

        return candies;
    }
}
