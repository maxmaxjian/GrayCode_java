import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Solution1 implements Solution {
    @Override
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();
        BitSet bset = new BitSet(n);
        result.add(bitSetToInt(bset, n));
        if (n > 1) {
            boolean ascending = false;
            int i = n-1;
            bset.flip(i);
            while (bset.cardinality() != 0) {
                System.out.println(bset);
                result.add(bitSetToInt(bset, n));
                if (ascending) {
                    if (i < n - 1) {
                        i++;
                    } else {
                        ascending = false;
                        i--;
                    }
                } else {
                    if (i > 0) {
                        i--;
                    } else {
                        ascending = true;
                        i++;
                    }
                }
                bset.flip(i);
            }
        } else if (n == 1) {
            bset.flip(0);
            result.add(bitSetToInt(bset, n));
        }

        return result;
    }

    private int bitSetToInt(BitSet bset, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result*2 + (bset.get(i) ? 1 : 0);
        }
        return result;
    }
}
