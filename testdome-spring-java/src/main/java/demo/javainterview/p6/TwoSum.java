package demo.javainterview.p6;

import java.util.Arrays;

/**
 * TODO : 다시
 */
public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        if (list == null || list.length < 2) {
            return null;
        }

        int[] copy = new int[list.length];
        System.arraycopy(list, 0, copy, 0, list.length);
        Arrays.sort(copy);

        int[] values = null;
        int left = 0;
        int right = 1;

        while (true) {
            int answer = copy[left] + copy[right];

            // 1) answer == sum
            if (answer == sum) {
                values = new int[] { copy[left], copy[right] };
                break;
            }

            // 2) answer > sum
            if (answer > sum) {
                break;
            }

            // 3) answer < sum
            if (right == list.length - 1) {
                left++;
            } else {
                right++;
            }
        }

        if (values == null) {
            return null;
        }

        int[] ret = new int[] { -1, -1 };

        for (int i = 0; i < list.length; i++) {
            if (ret[0] == -1 && values[0] == list[i]) {
                ret[0] = i;
            } else if (values[1] == list[i]) {
                ret[1] = i;
                break;
            }
        }

        if (ret[0] > ret[1]) {
            int t = ret[0];
            ret[0] = ret[1];
            ret[1] = t;
        }

        return ret;
    }

    public static void main(String[] args) {
        // int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        int[] indices = findTwoSum(new int[] { 2, 2 }, 4);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}