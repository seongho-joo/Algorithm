package _2018_KAKAO_BLIND_RECRUITMENT._3차.P4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solutionTest() {
        String m = "NNN";
        Solution s = new Solution();
        String res = s.solution(m,
            new String[]{"12:00,14:00,WORLD,ABC"});

        assertThat(res).isEqualTo("(None)");
    }

}