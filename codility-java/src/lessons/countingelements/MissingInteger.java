package lessons.countingelements;

import java.util.Arrays;

public class MissingInteger {
    public static void main(String[] args) {
        int[][] cases = new int[][] {
                { 1, 3, 6, 4, 1, 2 },
                { -1, -3 },
                { 1, 2, 3 },
                { 1 },
                { 3 },
                };
        for (int[] tc : cases) {
            System.out.printf("%s => %d\n", Arrays.toString(tc), new MissingInteger().solution(tc));
        }
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int require = 1;
        for (int a : A) {
            if (a == require) {
                require++;
            } else if (a > require) {
                return require;
            }
            // skip from negative integers to zero.
        }
        return require;
    }
}
