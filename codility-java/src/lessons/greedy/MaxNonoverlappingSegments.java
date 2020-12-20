package lessons.greedy;

public class MaxNonoverlappingSegments {

    public static void main(String[] args) {
        System.out.println(
                new MaxNonoverlappingSegments().solution(
                        new int[] { 1, 3, 7, 9, 9 },
                        new int[] { 5, 6, 7, 9, 11 }
                )
        );
    }

    public int solution(int[] A, int[] B) {
        int N = A.length;
        if (N <= 1) {
            return N;
        }

        int answer = 1;
        int prevEnd = B[0];

        for (int i = 1; i < N; i++) {
            if (prevEnd < A[i]) {
                answer++;
                prevEnd = B[i];
            }
        }

        return answer;
    }
}
