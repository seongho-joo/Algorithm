package Implementation.prg87390;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() throws Exception {
        // given
        Solution solution = new Solution();
        int[] res = {4,3,3,3,4,4,4,4};

        // then

        assertThat(solution.solution(4, 7, 14)).isEqualTo(res);
    }
}