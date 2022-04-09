package _2019_KAKAO_BLIND_RECRUITMENT.P1;

import java.util.*;

public class Solution {

    private Map<String, String> users = new HashMap<>();

    public String[] solution(String[] record) {
        String[] answer;
        String command;

        int len = 0;
        for (String s : record) {
            String[] line = s.split(" ");
            command = line[0];
            if (!command.equals("Leave")) {
                users.put(line[1], line[2]);
            }
            if (!command.equals("Change")) {
                len += 1;
            }
        }

        answer = new String[len];
        int i = 0;
        for (String s : record) {
            String[] line = s.split(" ");
            command = line[0];
            if (command.equals("Enter")) {
                answer[i++] = users.get(line[1]) + "님이 들어왔습니다.";
            } else if (command.equals("Leave")) {
                answer[i++] = users.get(line[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
