package stack.p42588;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().solution(new int[] { 1, 5, 3, 6, 7, 6, 5 }))
        );
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Pair> stack1 = new Stack<>();
        Stack<Pair> stack2 = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            stack1.push(new Pair(i, heights[i]));
        }

        while (!stack1.empty()) {
            Pair p = stack1.pop();
            Pair r = null;

            while (!stack1.empty()) {
                Pair t = stack1.pop();
                stack2.push(t);

                if (t.value > p.value) {
                    r = t;
                    break;
                }
            }

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            if (r == null) {
                answer[p.index] = 0;
            } else {
                answer[p.index] = r.index + 1;
            }
        }

        return answer;
    }

    static class Pair {

        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}