package Implementation.모음사전;

public class Solution {

    static final String MAPPING = "AEIOU";
    static final int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};

    static public int solution(String word) {
        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            answer += (RATE_OF_INCREASE[i] * MAPPING.indexOf(word.charAt(i)));
        }

        return answer;
    }
}