package _2018_KAKAO_BLIND_RECRUITMENT.P6;

public class Solution {

    private static char[][] block;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        initialize(board, m, n);
        while (true) {
            int cnt = simulation(m, n);
            if (cnt == 0) {
                break;
            }
            answer += cnt;
        }
        return answer;
    }

    private void initialize(String[] board, int m, int n) {
        block = new char[m][n];
        for (int i = 0; i < m; i++) {
            block[i] = board[i].toCharArray();
        }
    }

    private int simulation(int m, int n) {
        boolean[][] check = new boolean[m][n];
        int count;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (block[i][j] != '.' && checkBlock(i, j)) {
                    check[i][j] = check[i][j + 1] = check[i + 1][j] = check[i + 1][j + 1] = true;
                }
            }
        }

        count = updateBlockAndReturnCount(check, m, n);

        while (dropBlock(m, n))
            ;

        return count;
    }

    private int updateBlockAndReturnCount(boolean[][] check, int m, int n) {
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    ret += 1;
                    block[i][j] = '.';
                }
            }
        }
        return ret;
    }

    private boolean dropBlock(int m, int n) {
        boolean isMoved = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (block[j][i] != '.' && block[j + 1][i] == '.') {
                    block[j + 1][i] = block[j][i];
                    block[j][i] = '.';
                    isMoved = true;
                }
            }
        }
        return isMoved;
    }

    private boolean checkBlock(int i, int j) {
        char c = block[i][j];
        return (c == block[i][j + 1] && c == block[i + 1][j] && c == block[i + 1][j + 1]);
    }
}
