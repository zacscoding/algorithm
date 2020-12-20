package lessons.leader;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
    public static void main(String[] args) {
        System.out.println(
                new Dominator().solution(
                        new int[] { 3, 4, 3, 2, 3, -1, 3, 3 }
                )
        );
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return -1;
        }

        // key : value of A, value: array of counter,index
        Map<Integer, int[]> counters = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int[] counter = counters.get(A[i]);
            if (counter == null) {
                counter = new int[] { 0, i };
                counters.put(A[i], counter);
            }
            counter[0]++;
        }
        int half = A.length / 2;
        for (int[] counter : counters.values()) {
            if (counter[0] > half) {
                return counter[1];
            }
        }
        return -1;
    }
}
