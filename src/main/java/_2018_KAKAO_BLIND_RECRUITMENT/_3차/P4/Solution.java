package _2018_KAKAO_BLIND_RECRUITMENT._3차.P4;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    List<Info> list = new ArrayList<>();

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        m = codeReplace(m);

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            StringBuilder melody = new StringBuilder(codeReplace(split[3]));

            int runningTime = getRunningTime(split[0].split(":"), split[1].split(":"));

            if (runningTime >= melody.length()) {
                String origin = melody.toString();
                while (melody.length() != runningTime) {
                    if (melody.length() + origin.length() >= runningTime) {
                        int diff = runningTime - melody.length();
                        melody.append(melody.substring(0, diff));
                        continue;
                    }
                    melody.append(origin);
                }
                String substring = melody.substring(0, runningTime - melody.length());
                melody.append(substring);
            } else {
                melody = new StringBuilder(melody.substring(0, runningTime));
            }

            list.add(new Info(runningTime, split[2], melody.toString()));
        }

        Collections.sort(list);

        for (Info info : list) {
            if (info.melody.contains(m)) {
                answer = info.title;
                break;
            }
        }

        return answer;
    }

    private String codeReplace(String code) {
        code = code.replaceAll("C#", "c");
        code = code.replaceAll("D#", "d");
        code = code.replaceAll("F#", "f");
        code = code.replaceAll("G#", "g");
        code = code.replaceAll("A#", "a");
        return code;
    }

    private int getRunningTime(String[] start, String[] end) {
        int startTime = parseInt(start[0]) * 60 + parseInt(start[1]);
        int endTime = parseInt(end[0]) * 60 + parseInt(end[1]);

        return endTime - startTime;
    }

    private static class Info implements Comparable<Info>{

        int runningTime;
        String title;
        String melody;

        public Info(int runningTime, String title, String melody) {
            this.runningTime = runningTime;
            this.title = title;
            this.melody = melody;
        }

        @Override
        public int compareTo(Info info) {
            return info.runningTime - this.runningTime;
        }
    }
}
