public class LeetCode_2486_AppendCharacterstoStringtoMakeSubsequence {
    public int appendCharacters(String s, String t) {

        if (s.equals(t))
            return 0;

        int sIndex = 0, tIndex = 0;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        while (sIndex < sCharArray.length && tIndex < tCharArray.length) {

            if (sCharArray[sIndex] == tCharArray[tIndex]) {
                tIndex++;
            }
            sIndex++;
        }

        return tCharArray.length - tIndex;
    }
}
