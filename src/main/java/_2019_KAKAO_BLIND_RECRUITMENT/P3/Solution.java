package _2019_KAKAO_BLIND_RECRUITMENT.P3;

import java.util.*;

public class Solution {

    private ArrayList<Integer> candidateKey = new ArrayList<>();

    public int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;

        for (int i = 1; i < (1 << m); i++) {
            if (!isSatisfyMinimality(i)) {
                continue;
            }

            Set<String> set = new HashSet<>();
            for (String[] tuple : relation) {
                StringBuilder data = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) != 0) {
                        data.append(tuple[j]);
                    }
                }
                set.add(data.toString());
            }
            if (set.size() == n) {
                candidateKey.add(i);
            }
        }
        return candidateKey.size();
    }

    private boolean isSatisfyMinimality(int i) {
        for (int key : candidateKey) {
            if ((i & key) == key) {
                return false;
            }
        }
        return true;
    }
}
