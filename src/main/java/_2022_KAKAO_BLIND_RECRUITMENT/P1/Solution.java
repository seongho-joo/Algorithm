package _2022_KAKAO_BLIND_RECRUITMENT.P1;

import java.util.*;

public class Solution {

    Map<String, Integer> users = new HashMap<>();
    boolean[][] reportList;
    int[] numberOfReport;

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        int len = id_list.length;
        reportList = new boolean[len][len];
        numberOfReport = new int[len];
        answer = new int[len];

        initList(id_list);
        enterReportList(report);
        countNumberOfReport(len);

        for (int i = 0; i < len; i++) {
            if (numberOfReport[i] >= k) {
                list.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            for (Integer integer : list) {
                if (reportList[i][integer]) {
                    answer[i] += 1;
                }
            }
        }

        return answer;
    }

    private void countNumberOfReport(int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (reportList[i][j]) {
                    numberOfReport[j] += 1;
                }
            }
        }
    }

    private void enterReportList(String[] report) {
        for (String s : report) {
            String[] split = s.split(" ");
            int reporter, respondent;
            reporter = users.get(split[0]);
            respondent = users.get(split[1]);
            reportList[reporter][respondent] = true;
        }
    }

    private void initList(String[] id_list) {
        int idx = 0;
        for (String s : id_list) {
            users.put(s, idx);
            idx += 1;
        }
    }
}
