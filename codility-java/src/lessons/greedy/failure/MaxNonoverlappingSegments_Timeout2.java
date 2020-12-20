package lessons.greedy.failure;

import java.util.*;

public class MaxNonoverlappingSegments_Timeout2 {
    public static void main(String[] args) {
        System.out.println(
                new MaxNonoverlappingSegments_Timeout().solution(
                        new int[] { 1, 3, 7, 9, 9 },
                        new int[] { 5, 6, 8, 9, 10 }
                )
        );
    }

    public int solution(int[] A, int[] B) {
        if (A.length == 0) {
            return 0;
        }
        PriorityQueue<Seg> que = new PriorityQueue<>(A.length, Comparator.comparingInt(Seg::Range));
        for (int i = 0; i < A.length; i++) {
            que.offer(new Seg(A[i], B[i]));
        }
        Deque<Seg> deque = new LinkedList<>();
        while (!que.isEmpty()) {
            deque.addLast(que.poll());
        }
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if (deque.isEmpty()) {
                break;
            }
            Seg seg = deque.pollFirst();
            answer++;
            int repeat = deque.size();
            while (!deque.isEmpty() && repeat-- > 0) {
                Seg comp = deque.pollFirst();
                if (!seg.IsOverlapping(comp)) {
                    deque.addLast(comp);
                }
            }
        }
        return answer;
    }

    public static class Seg {
        int from;
        int to;

        public Seg(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public boolean IsOverlapping(Seg other) {
            if (other.to < from || other.from > to) {
                return false;
            }
            return true;
        }

        public int Range() {
            return to - from;
        }
    }
}
