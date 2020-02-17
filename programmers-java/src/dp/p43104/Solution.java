package dp.p43104;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43104
 */
class Solution {

    static long[] a = new long[81];

    static {
        a[1] = 1L;
        a[2] = 1L;
        a[3] = 2L;
        a[4] = 3L;
    }

    public long solution(int N) {
        return 2 * get(N) + 2 * (get(N) + get(N - 1));
    }

    static long get(int idx) {
        if (idx == 0) {
            return 0;
        }

        if (a[idx] != 0) {
            return a[idx];
        }

        return a[idx] = get(idx - 1) + get(idx - 3) + get(idx - 4);
    }
}