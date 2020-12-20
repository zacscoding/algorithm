package lessons.binarysearch.failure;

public class MinMaxDivision_Timeout1 {
    public static void main(String[] args) {
        System.out.println(
                new MinMaxDivision_Timeout1().solution(0, 5, new int[] { 2, 1, 5, 1, 2, 2, 2 })
        );
    }

    public int solution(int K, int M, int[] A) {
        if (K == 0 || A.length == 0) {
            return 0;
        }
        if (K == 1) {
            int sum = 0;
            for (int a : A) {
                sum += a;
            }
            return sum;
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int[] copy = new int[A.length - i - 1];
            System.arraycopy(A, i + 1, copy, 0, A.length - i - 1);
            int answer = solution(K - 1, M, copy);
            int cand = Math.max(sum, answer);
            min = Math.min(min, cand);
        }
        return min;
    }
}
