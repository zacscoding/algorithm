package greedy.p42885;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> que = new LinkedList<>();
        for (int p : people) {
            que.addLast(p);
        }

        int answer = 0;
        while (!que.isEmpty()) {
            int current = que.removeFirst();
            int min = limit - current;
            int currLimit = min;

            while (!que.isEmpty()) {
                int last = que.removeLast();

                if (last > min) {
                    answer++;
                    continue;
                }

                if (last <= currLimit) {
                    currLimit -= last;
                } else {
                    que.addLast(last);
                    break;
                }
            }

            answer++;
        }

        return answer;
    }
}