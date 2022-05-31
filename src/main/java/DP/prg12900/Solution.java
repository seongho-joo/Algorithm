package DP.prg12900;

public class Solution {

    private static final int MOD = 1000000007;

    public int solution(int n) {
        int[] tiles = new int[n + 1];

        tiles[1] = 1;
        tiles[2] = 2;

        for (int i = 3; i <= n; i++) {
            tiles[i] = (tiles[i - 1] + tiles[i - 2]) % MOD;
        }

        return tiles[n];
    }
}
