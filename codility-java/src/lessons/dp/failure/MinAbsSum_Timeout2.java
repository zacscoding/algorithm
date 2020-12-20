package lessons.dp.failure;

import java.util.Deque;
import java.util.LinkedList;

public class MinAbsSum_Timeout2 {

    public static void main(String[] args) {
        System.out.println(
                new MinAbsSum_Timeout2().solution(
                        new int[] { 1, 2, 2, 3, 5, 5, 1, 1 }
                )
        );
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return Math.abs(A[0]);
        }

        int answer = Math.abs(A[0]);
        int len = 1;
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(answer);

        for (int i = 1; i < A.length; i++) {
            // initialize answer
            answer = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                int prev = deque.pollFirst();
                int new1 = Math.abs(prev + A[i]);
                int new2 = Math.abs(prev - A[i]);
                answer = Math.min(Math.min(new1, new2), answer);
                deque.addLast(new1);
                deque.addLast(new2);
            }
            len *= 2;
        }
        return answer;
    }
}
