package _2018_KAKAO_BLIND_RECRUITMENT.P6;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        // given
        Solution s = new Solution();
        int answer = 14;
        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        // then
        assertThat(s.solution(m, n, board)).isEqualTo(answer);
    }
}