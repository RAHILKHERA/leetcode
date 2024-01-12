public class LeetCode_1704_DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {

        int i = 0, j = s.length() / 2, countI = 0, countJ = 0;
        char[] chArray = s.toCharArray();

        while (j < s.length()) {
            if (isVowel(chArray[i])) {
                countI++;
            }

            if (isVowel(chArray[j])) {
                countJ++;
            }
            i++;
            j++;
        }

        return countI == countJ;

    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
