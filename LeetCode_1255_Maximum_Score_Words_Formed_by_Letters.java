public class LeetCode_1255_Maximum_Score_Words_Formed_by_Letters {

    /**
     * Important
     * BackTracking
     * Include Exclude
     */

    private int[] freq;
    private int maxScore;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int W = words.length;

        freq = new int[26];

        for (char ch : letters) {
            freq[ch - 'a']++;
        }

        backtracking(W - 1, words, score, new int[26], 0);
        return maxScore;
    }

    private boolean isValid(int[] subSetFreq) {

        for (int i = 0; i < 26; i++) {
            if (freq[i] < subSetFreq[i]) {
                return false;
            }
        }
        return true;
    }

    private void backtracking(int w, String[] words, int[] score, int[] subSetFreq, int currentScore) {

        // Base condition,
        if (w == -1) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        // Don't include the word;

        backtracking(w - 1, words, score, subSetFreq, currentScore);

        // Include the word
        int length = words[w].length();

        // Calculate effect of choosing this word. It will effect both the subSetFreq
        // and also the currentScore.

        for (int i = 0; i < length; i++) {
            int c = words[w].charAt(i) - 'a';
            currentScore += score[c];
            subSetFreq[c]++;
        }

        // If word is valid in the subset, go ahead with the other possibilites having
        // this word.

        if (isValid(subSetFreq)) {
            backtracking(w - 1, words, score, subSetFreq, currentScore);
        }

        // Either the word was invalid or all the posibilites with the current word in
        // the subset is covered. So REVERSE the effect on the currentScore and
        // subSetFreq.

        for (int i = 0; i < length; i++) {
            int c = words[w].charAt(i) - 'a';
            currentScore -= score[c];
            subSetFreq[c]--;
        }

    }
}
