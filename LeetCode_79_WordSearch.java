import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LeetCode_79_WordSearch {

    @Test
    public void test1() {
        assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },
                "ABCCED"));
    }

    @Test
    public void test2() {
        assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },
                "SEE"));
    }

    @Test
    public void test3() {
        assertFalse(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },
                "ABCB"));
    }

    @Test
    public void test4() {
        assertTrue(exist(new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } },
                "AAB"));
    }

    @Test
    public void test5() {
        assertTrue(exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } },
                "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int index, int i, int j) {

        if (index == word.length())
            return true;

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] += 100;

        boolean result = backtrack(board, word, index + 1, i + 1, j) ||
                backtrack(board, word, index + 1, i - 1, j) ||
                backtrack(board, word, index + 1, i, j + 1) ||
                backtrack(board, word, index + 1, i, j - 1);

        board[i][j] -= 100;

        return result;
    }
}
