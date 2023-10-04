package Implementation.prg49993;

import java.util.*;

class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String s : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                String temp = String.valueOf(s.charAt(i));
                if (skill.contains(temp)) {
                    sb.append(temp);
                }
            }

            boolean flag = false;
            for (int i = 0; i < sb.length(); i++) {
                if (skill.charAt(i) != sb.toString().charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer += 1;
            }
        }
        return answer;
    }
}
