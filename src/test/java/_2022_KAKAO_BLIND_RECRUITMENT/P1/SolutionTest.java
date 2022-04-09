package _2022_KAKAO_BLIND_RECRUITMENT.P1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {


    @Test
    void test1() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] result = {2, 1, 1, 0};
        Solution s = new Solution();

        assertThat(s.solution(id_list, report, k)).isEqualTo(result);
    }

    @Test
    void test2() {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        int[] result = {0, 0};
        Solution s = new Solution();

        assertThat(s.solution(id_list, report, k)).isEqualTo(result);
    }
}