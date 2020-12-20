package lessons.prefixsums;

public class CountDiv {
    public static void main(String[] args) {
        int[][] cases = new int[][] {
                { 6, 11, 2 },
                { 1, 5, 6 },
                { 0, 5, 6 },
                { 0, 6, 6 },
                { 10, 10, 7 }
        };
        for (int[] tc : cases) {
            System.out.printf("A:%d, B:%d, K:%d -> %d\n", tc[0], tc[1], tc[2],
                              new CountDiv().solution(tc[0], tc[1], tc[2]));
        }
    }

    public int solution(int A, int B, int K) {
        if (B < K) {
            return A == 0 ? 1 : 0;
        }
        int answer = 0;
        if (A < K) {
            if (A == 0) {
                answer++;
            }
            A = K;
        }

        int start = (A % K) + A;
        int end = (B - start + 1);

        if (end < 1) {
            return answer;
        }
        answer += end / K;
        if (end % K != 0) {
            answer++;
        }
        return answer;
    }
}
