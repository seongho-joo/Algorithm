package _2018_KAKAO_BLIND_RECRUITMENT._3차.P2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solutionTest() {
        // given
        Solution s = new Solution();
        int[] res = {20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34};

        // when
        int[] ret = s.solution("TOBEORNOTTOBEORTOBEORNOT");

        // then
        assertThat(res).isEqualTo(ret);
    }

}