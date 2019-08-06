package chap17.partialsum.define;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @GitHub : https://github.com/zacscoding
 */
public class PartialSumDefault {

    public static List<Integer> partialSum(List<Integer> a) {
        List<Integer> ret = new ArrayList<>(a.size());
        ret.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            ret.add(ret.get(i - 1) + a.get(i));
        }
        return ret;
    }

    public static int rangeSum(List<Integer> psum, int a, int b) {
        if (a == 0) { return psum.get(b); }
        return psum.get(b) - psum.get(a - 1);
    }
}
