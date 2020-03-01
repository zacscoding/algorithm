package stack.p42586;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        boolean hasComplete = false;
        int days = 0;
        int complete = 0;

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i] + (speeds[i] * days);

            if (progress >= 100) {
                complete++;
                hasComplete = true;
                continue;
            }

            if (hasComplete) {
                answer.add(complete);
            }

            int d = (int) Math.ceil((100 - progress) / (double) speeds[i]);
            complete = 1;
            days += d;
            hasComplete = true;
        }

        if (complete != 0) {
            answer.add(complete);
        }

        int[] ret = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            ret[i] = answer.get(i);
        }

        return ret;
    }
}