package DP.prg12902;

public class Solution {

    private static final int MOD = 1000000007;

    public int solution(int n) {
        long[] tiles = new long[n + 1];

        tiles[0] = 1;
        tiles[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            tiles[i] = tiles[i - 2] * 3;
            for (int j = i - 4; j >= 0 ; j -= 2) {
                tiles[i] += (tiles[j] * 2);
            }
            tiles[i] %= MOD;
        }

        return (int) tiles[n];
    }
}