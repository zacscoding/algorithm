package lessons.dp.failure;

import java.util.Arrays;

public class MinAbsSum_Wrong {
    public static void main(String[] args) {
        System.out.println(
                new MinAbsSum_Wrong().solution(new int[] { 1, 5, -2, 5, 2, 3 })
        );
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return Math.abs(A[0]);
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                A[i] *= -1;
            }
        }
        Arrays.sort(A);

        int[] psum = new int[A.length];
        psum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            psum[i] = psum[i - 1] + A[i];
        }
        int answer = Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 1; i--) {
            int left = psum[i - 1];
            int right = psum[A.length - 1] - left;
            answer = Math.min(answer, Math.abs(right - left));
        }
        return answer;
    }
}
