package Simulation.prg49994;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        // given
        Solution s = new Solution();

        // then

        assertThat(s.solution("LR")).isEqualTo(1);
    }
}