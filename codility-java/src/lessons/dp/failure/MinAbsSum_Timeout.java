package lessons.dp.failure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Brute force
 */
public class MinAbsSum_Timeout {
    public static void main(String[] args) {
        System.out.println(
                new MinAbsSum_Timeout().solution(new int[] { 1, 2 })
        );
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int answer = Math.abs(A[0]);
        Set<Integer> set = new HashSet<>();
        set.add(answer);

        for (int i = 1; i < A.length; i++) {
            answer = Integer.MAX_VALUE;
            Set<Integer> temp = new HashSet<>();
            Iterator<Integer> itr = set.iterator();
            while (itr.hasNext()) {
                int t = itr.next();
                int c1 = Math.abs(t - A[i]);
                int c2 = Math.abs(t + A[i]);
                temp.add(c1);
                temp.add(c2);
                answer = Math.min(Math.min(answer, c1), c2);
            }
            set = temp;
        }
        return answer;
    }
}
