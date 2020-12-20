package lessons.countingelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxCounters {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new MaxCounters().solution(5,
                                                   new int[] { 1, 6, 6, 6, 6 })
                )
        );
    }

    public int[] solution(int N, int[] A) {
        List<Integer> maxCounterIndexes = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                maxCounterIndexes.add(i);
            }
        }

        int startIdx = 0, initial = 0;
        for (Integer maxCounterIdx : maxCounterIndexes) {
            int endIdx = maxCounterIdx - 1;
            if (startIdx == endIdx) {
                initial += (A[startIdx] == N + 1) ? 0 : 1;
            } else if (startIdx < endIdx) {
                initial += maxCount(N, A, startIdx, endIdx);
            }
            startIdx = maxCounterIdx + 1;
        }

        int[] counters = new int[N];
        if (initial != 0) {
            Arrays.fill(counters, initial);
        }
        for (int i = startIdx; i < A.length; i++) {
            counters[A[i] - 1]++;
        }
        return counters;
    }

    public int maxCount(int N, int[] A, int startIdx, int endIdx) {
        int[] count = new int[N];
        int max = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            count[A[i] - 1]++;
            max = Math.max(max, count[A[i] - 1]);
        }
        return max;
    }
}
