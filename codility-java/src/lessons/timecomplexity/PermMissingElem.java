package lessons.timecomplexity;

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(
                (1000001 * 1000002) / 2
        );
        System.out.println(
                new PermMissingElem().solution(new int[] { 2, 3, 1, 5 })
        );
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        long sum = 0;
        for (int a : A) {
            sum += a;
        }
        long totalSum = (long) (A.length + 1) * (A.length + 2) / 2;
        return (int) (totalSum - sum);
    }
}
