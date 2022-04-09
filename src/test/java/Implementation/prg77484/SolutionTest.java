package Implementation.prg77484;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {

    }

    @Test
    void solution() {
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        Solution s3 = new Solution();

        int[] res1 = {3, 5};
        int[] res2 = {1, 6};
        int[] res3 = {1, 1};

        assertThat(s1.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})).isEqualTo(res1);

    }
}