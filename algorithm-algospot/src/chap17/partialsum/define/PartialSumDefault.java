package chap17.partialsum.define;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @GitHub : https://github.com/zacscoding
 */
public class PartialSumDefault {

    /**
     * a 리스트의 부분합
     */
    public static List<Integer> partialSum(List<Integer> a) {
        List<Integer> ret = new ArrayList<>(a.size());
        ret.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            ret.add(ret.get(i - 1) + a.get(i));
        }
        return ret;
    }

    /**
     * psum[a,b] 값
     */
    public static int rangeSum(List<Integer> psum, int a, int b) {
        if (a == 0) { return psum.get(b); }
        return psum.get(b) - psum.get(a - 1);
    }

    /**
     * A[]의 제곱의 부분 합 벡터 sqpsum, A[]의 부분 합 벡터 psum
     * => A[a,b]의 분산을 반환
     */
    public static double variance(List<Integer> sqpsum, List<Integer> psum, int a, int b) {
        double mean = rangeSum(psum, a, b) / (double) (b - a + 1);
        double ret = rangeSum(sqpsum, a, b) - 2 * mean * rangeSum(psum, a, b)
                     + (b - a + 1) * mean * mean;
        return ret;
    }

    /**
     * 2차원 배열 A[][]의 부분합 psum[][]이 주어질 때
     * A[y1,x1], A[y2,x2]를 양끝으로 갖는 부분 배열의 합을 반환
     */
    public static int gridSum(List<List<Integer>> psum, int y1, int x1, int y2, int x2) {
        int ret = psum.get(y2).get(x2);

        if (y1 > 0) { ret -= psum.get(y1 - 1).get(x2); }
        if (x1 > 0) { ret -= psum.get(y2).get(x1 - 1); }
        if (y1 > 0 && x1 > 0) {ret += psum.get(y1 - 1).get(x1 - 1);}

        return ret;
    }
}
