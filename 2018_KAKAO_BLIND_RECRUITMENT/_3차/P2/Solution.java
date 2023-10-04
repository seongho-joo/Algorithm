package _2018_KAKAO_BLIND_RECRUITMENT._3차.P2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private final Map<String, Integer> map = new HashMap<>();
    private int index = 1;

    public int[] solution(String msg) {
        int[] answer;
        List<Integer> output = new ArrayList<>();

        init();
        StringBuilder w = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            w.append(String.valueOf(msg.charAt(i)));
            String wc = "";
            if (i + 1 < msg.length()) {
               String c = String.valueOf(msg.charAt(i + 1));
                wc = w + c;
                if (map.containsKey(wc)) {
                    continue;
                }
            }
            output.add(map.get(w.toString()));
            map.put(wc, index++);
            w = new StringBuilder();
        }
        answer = output.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    private void init() {
        char start = 'A';
        for (; index <= 26; index += 1) {
            map.put(String.valueOf(start++), index);
        }
    }
}