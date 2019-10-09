package bruteforce.p42840;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Solution {
    public int[] solution(int[] answers) {
        int[] a1 = { 1, 2, 3, 4, 5 };
        int[] a2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] a3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] count = new int[4];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a1[i % a1.length]) {
                count[1]++;
            }
            if (answers[i] == a2[i % a2.length]) {
                count[2]++;
            }
            if (answers[i] == a3[i % a3.length]) {
                count[3]++;
            }
        }

        int max = 0;
        for (int i = 1; i <= 3; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        int[] answer = new int[3];
        int idx = 0;
        for (int i = 1; i <= 3; i++) {
            if (count[i] == max) {
                answer[idx++] = i;
            }
        }

        return (idx == 3) ? answer : Arrays.copyOf(answer, idx);
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().solution(new int[] { 1, 2, 3, 4, 5 }))
        );

        System.out.println("--------------------------------------------------------");
        System.out.println(
                Arrays.toString(new Solution().solution(new int[] { 1, 3, 2, 4, 2 }))
        );

        System.out.println("--------------------------------------------------------");
        System.out.println(
                Arrays.toString(new Solution().solution(new int[] { 5 }))
        );
    }
}
