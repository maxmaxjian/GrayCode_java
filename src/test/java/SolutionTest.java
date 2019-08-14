import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int input;
    private List<Integer> expected;
    private Solution soln = new Solution2();

    public SolutionTest(int input, int[] output) {
        this.input = input;
        this.expected = IntStream.of(output).boxed().collect(Collectors.toList());
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {2, new int[]{0,1,3,2}},
                {0, new int[]{0}},
                {1, new int[]{0,1}},
                {4, new int[]{0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8}}
        });
    }

    @Test
    public void test() {
        assertEquals(expected, soln.grayCode(input));
    }

}