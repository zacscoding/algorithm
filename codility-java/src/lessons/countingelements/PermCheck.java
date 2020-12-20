package lessons.countingelements;

import java.util.Arrays;

public class PermCheck {
    public static void main(String[] args) {
        int[][] cases = new int[][] {
                { 4, 1, 3, 2 },
                { 1, 1 },
                { 1, 5 },
                { 1, 3, 3 }
        };
        for (int[] tc : cases) {
            System.out.printf("A:%s => %d\n", Arrays.toString(tc), new PermCheck().solution(tc));
        }
    }

    public int solution(int[] A) {
        // find max
        int max = 0;
        for (int a : A) {
            if (max < a) {
                max = a;
            }
        }
        // fast fail
        if (A.length != max) {
            return 0;
        }
        // check once
        int[] arr = new int[max + 1];
        for (int a : A) {
            arr[a]++;
            if (arr[a] != 1) {
                return 0;
            }
        }
        return 1;
    }
}
