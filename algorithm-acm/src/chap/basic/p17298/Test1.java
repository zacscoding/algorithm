package chap.basic.p17298;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @GitHub : https://github.com/zacscoding
 */
public class Test1 {

    static int n;
    static int[] a;
    static int[] expected;
    static int[] solved;

    public static void main(String[] args) {
        int testCase = 100;
        int testCount = testCase;
        int range = 1000000 - 1;
        int success = 0;

        while (testCount-- > 0) {
            // random input
            n = new Random().nextInt(range) + 1;
            a = new int[n];
            expected = new int[n];
            solved = new int[n];

            Set<Integer> nums = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int val;
                while (true) {
                    val = new Random().nextInt(1000000 - 1) + 1;

                    if (!nums.contains(val)) {
                        nums.add(val);
                        break;
                    }
                }

                a[i] = val;
            }

            // shuffle
            for (int i = n; i > 1; i--) {
                swap(i - 1, new Random().nextInt(i));
            }

            // O(n^2)
            for (int i = 0; i < n; i++) {
                expected[i] = -1;
                for (int j = i + 1; j < n; j++) {
                    if (a[i] < a[j]) {
                        expected[i] = a[j];
                        break;
                    }
                }
            }

            solve();

            if (!Arrays.equals(solved, expected)) {
                System.out.println("----------------------------------------------------");
                System.out.println("## Find wrong answer with n : " + n);
                System.out.println("Input : " + Arrays.toString(a));
                System.out.println("Expected : " + Arrays.toString(expected));
                System.out.println("Solved : " + Arrays.toString(solved));
                System.out.println("----------------------------------------------------");
            } else {
                success++;
            }
        }

        System.out.println("Test case : " + testCase + ", Success : " + success);
    }

    private static void solve2() {
        Input[] inputs = new Input[n];
        Stack<Input> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            inputs[i] = new Input(i, a[i]);
        }

        stack.push(inputs[0]);
        Input elt, next;

        for (int i = 1; i < n; i++) {
            next = inputs[i];

            if (!stack.isEmpty()) {
                elt = stack.pop();

                while (elt.val < next.val) {
                    elt.nge = next.val;

                    if (stack.isEmpty()) {
                        break;
                    }

                    elt = stack.pop();
                }

                if (elt.val > next.val) {
                    stack.push(elt);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            solved[i] = inputs[i].nge;
        }
    }

    private static void solve() {
        Input[] inputs = new Input[n];
        Stack<Input> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            inputs[i] = new Input(i, a[i]);
        }

        stack.push(inputs[0]);

        for (int i = 1; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(inputs[i]);
                continue;
            }

            if (stack.peek().val > inputs[i].val) {
                stack.push(inputs[i]);
                continue;
            }

            while (!stack.isEmpty()) {
                if (stack.peek().val > inputs[i].val) {
                    break;
                }

                stack.pop().nge = inputs[i].val;
            }

            stack.push(inputs[i]);
        }

        for (int i = 0; i < n; i++) {
            solved[i] = inputs[i].nge;
        }
    }

    static void swap(int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }

    static class Input {
        int idx;
        int val;
        int nge = -1;

        public Input(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
