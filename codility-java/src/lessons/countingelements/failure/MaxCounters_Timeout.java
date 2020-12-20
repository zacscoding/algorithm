package lessons.countingelements.failure;

import java.util.Arrays;

public class MaxCounters_Timeout {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new MaxCounters_Timeout().solution(5,
                                                           new int[] { 3, 4, 4, 6, 1, 4, 4 })
                )
        );
    }

    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int max = 0;

        for (int a : A) {
            if (a <= N) {
                counter[a - 1]++;
                max = Math.max(max, counter[a - 1]);
            } else {
                Arrays.fill(counter, max);
            }
        }
        return counter;
    }
}
