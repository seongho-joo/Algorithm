package DivideAndConquer.prg68936;

public class Solution {

    int[] count = new int[2];
    int[][] quadtree;

    public int[] solution(int[][] arr) {
        quadtree = arr;
        int n = arr.length;
        Compress(n, 0, 0);
        return count;
    }

    private void Compress(int n, int y, int x) {
        int cur = quadtree[y][x];
        if (isPossibleCompression(n, y, x)) {
            count[cur] += 1;
        } else {
            int scope = n / 2;
            Compress(scope, y, x); // 좌상
            Compress(scope, y, x + scope); // 우상
            Compress(scope, y + scope, x); // 좌하
            Compress(scope, y + scope, x + scope); // 우하
        }
    }

    private boolean isPossibleCompression(int n, int y, int x) {
        int cur = quadtree[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (cur != quadtree[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
