import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 implements Solution {
    @Override
    public List<Integer> grayCode(int n) {

        if (n == 0) {
            return Arrays.asList(0);
        } else if (n == 1) {
            return Arrays.asList(0, 1);
        } else {
            List<Integer> prev = grayCode(n-1);
            List<Integer> result =  new ArrayList<>();
            result.addAll(prev);
            for (int i = prev.size()-1; i >= 0; i--) {
                result.add((1 << (n-1)) + prev.get(i));
            }
            return result;
        }

    }
}
