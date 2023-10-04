package Iteration.prg12980;

public class Solution {

    public static int solution(int n) {
        int ans = 1;
        while (n != 1) {
            if (n % 2 == 1) {
                ans += 1;
            }
            n /= 2;
        }
        return ans;
    }
}

