package greedy.p42885;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Timeout1 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] complete = new boolean[people.length];
        int answer = 0;

        for (int i = 0; i < people.length; i++) {
            if (complete[i]) {
                break;
            }

            complete[i] = true;
            int curLimit = limit - people[i];

            for (int j = people.length - 1; j > i; j--) {
                if (complete[j] || curLimit < people[j]) {
                    continue;
                }

                curLimit -= people[j];
                complete[j] = true;
            }

            answer++;
        }

        return answer;
    }
}