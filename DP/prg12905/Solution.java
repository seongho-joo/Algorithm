package DP.prg12905;

public class Solution {

    private int[][] cache;

    public int solution(int[][] board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        init(board, row, col);

        if (row == 1 && col == 1) {
            answer = board[0][0] * board[0][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 0) {
                    cache[i][j] = 0;
                } else {
                    cache[i][j] = Math.min(cache[i - 1][j - 1], Math.min(cache[i - 1][j], cache[i][j - 1])) + 1;
                    answer = Math.max(answer, cache[i][j]);
                }
            }
        }

        return answer * answer;
    }

    private void init(int[][] board, int row, int col) {
        cache = new int[row][col];

        cache[0][0] = board[0][0];

        for (int i = 0; i < row; i++) {
            cache[i][0] = board[i][0];
        }

        for (int i = 0; i < col; i++) {
            cache[0][i] = board[0][i];
        }
    }
}