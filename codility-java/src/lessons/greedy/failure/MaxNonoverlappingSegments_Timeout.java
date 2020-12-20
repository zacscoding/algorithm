package lessons.greedy.failure;

import java.util.*;

public class MaxNonoverlappingSegments_Timeout {
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
        List<Seg> answers = new ArrayList<>(A.length);
        while (!que.isEmpty()) {
            Seg seg = que.poll();
            boolean overlap = false;
            for (Seg answer : answers) {
                if (answer.IsOverlapping(seg)) {
                    overlap = true;
                    break;
                }
            }
            if (overlap == false) {
                answers.add(seg);
            }
        }
        return answers.size();
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
