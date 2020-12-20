package lessons.countingelements;

public class FrogRiverOne {
    public static void main(String[] args) {
        System.out.println(
                new FrogRiverOne().solution(5, new int[] {
                        1, 3, 1, 4, 2, 3, 5, 4
                })
        );
    }

    public int solution(int X, int[] A) {
        boolean[] exist = new boolean[X + 1];
        int remain = X;
        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            if (exist[A[i]]) {
                continue;
            }
            exist[A[i]] = true;
            remain--;
            answer = Math.max(answer, i);
        }

        return remain == 0 ? answer : -1;
    }
}
