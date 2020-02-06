package sort.p42748;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {
                1, 5, 2, 6, 3, 7, 4
        };
        int[][] commands = {
                { 2, 5, 3 },
                { 4, 4, 1 },
                { 1, 7, 3 }
        };

        System.out.println(Arrays.toString(new Solution().solution(arr, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0] - 1;
            int j = commands[l][1] - 1;
            int k = commands[l][2] - 1;
            int len = j - i + 1;

            int[] slice = new int[len];
            System.arraycopy(array, i, slice, 0, len);
            Arrays.sort(slice);

            answer[l] = slice[k];
        }

        return answer;
    }
}
