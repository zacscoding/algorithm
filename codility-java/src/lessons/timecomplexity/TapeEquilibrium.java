package lessons.timecomplexity;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int len = A.length;
        int[] psum = new int[len];
        psum[0] = A[0];
        for (int i = 1; i < len; i++) {
            psum[i] = psum[i - 1] + A[i];
        }
        int total = psum[len - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int diff = psum[i] - (total - psum[i]);
            if (diff < 0) {
                diff *= -1;
            }
            min = Math.min(min, diff);
        }
        return min;
    }
}
