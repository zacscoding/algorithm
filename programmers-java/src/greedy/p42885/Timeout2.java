package greedy.p42885;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Timeout2 {

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

            Deque<Integer> temp = new LinkedList<>();

            while (!que.isEmpty()) {
                int last = que.removeLast();

                if (last > min) {
                    answer++;
                    continue;
                }

                if (last <= currLimit) {
                    currLimit -= last;
                } else {
                    temp.addFirst(last);
                }
            }

            while (!temp.isEmpty()) {
                que.addLast(temp.removeFirst());
            }

            answer++;
        }

        return answer;
    }
}