package lessons.arr;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (K == 0 || A.length == 0) {
            return A;
        }
        int len = A.length;
        K %= len;
        int[] ret = new int[len];

        for (int i = 0; i < len; i++) {
            int targetIdx = (i + K) % len;
            ret[targetIdx] = A[i];
        }

        return ret;
    }
}
