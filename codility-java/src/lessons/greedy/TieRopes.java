package lessons.greedy;

public class TieRopes {
    public static void main(String[] args) {
        System.out.println(
                new TieRopes().solution(4, new int[] { 1, 2, 3, 4, 1, 1, 3 })
        );
    }

    public int solution(int K, int[] A) {
        int sum = 0, answer = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= K) {
                sum = 0;
                answer++;
            }
        }
        return answer;
    }
}
