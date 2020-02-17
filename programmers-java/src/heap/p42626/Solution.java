package heap.p42626;

import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7)
        );
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int s : scoville) {
            que.offer(s);
        }

        int answer = 0;

        while (true) {
            if (que.peek() >= K) {
                break;
            }

            if (que.size() == 1) {
                answer = -1;
                break;
            }

            int a = que.poll();
            int b = que.poll();

            int c = a + (b * 2);
            que.offer(c);
            answer++;
        }

        return answer;
    }
}