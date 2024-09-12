public class LeetCode_3222_FindtheWinningPlayerinCoinGame {

    public String losingPlayer(int x, int y) {

        int turns = y / 4;

        int min = x < turns ? x : turns;

        if (min % 2 == 0) {
            return "Bob";
        } else {
            return "Alice";
        }

    }
}