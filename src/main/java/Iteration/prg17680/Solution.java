package Iteration.prg17680;

public class Solution {

    private static int numberOfZeros = 0;

    public static int[] solution(String s) {
        int count = 0;
        while (!s.equals("1")) {
            count += 1;
            int nextNumber = s.length() - getNumberOfZeros(s);
            s = Integer.toBinaryString(nextNumber);
        }

        return new int[]{count, numberOfZeros};
    }

    private static int getNumberOfZeros(String sb) {
        int ret = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                ret += 1;
            }
        }
        numberOfZeros += ret;
        return ret;
    }
}
