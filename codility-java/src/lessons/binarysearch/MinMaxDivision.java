package lessons.binarysearch;

public class MinMaxDivision {
    public static void main(String[] args) {
        System.out.println(
                new MinMaxDivision().solution(3, 5, new int[] { 2, 1, 5, 1, 2, 2, 2 })
                //new MinMaxDivision().possibleDivide(3, new int[] { 2, 1, 5, 1, 2, 2, 2 }, 5)
        );
    }

    public int solution(int K, int M, int[] A) {
        int low = 0, high = 0;
        for (int a : A) {
            high += a;
            low = Math.max(low, a);
        }
        int answer = high;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (possibleDivide(K, A, mid)) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public boolean possibleDivide(int k, int[] A, int mid) {
        int remainBlock = k;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if (sum > mid) {
                remainBlock--;
                sum = A[i];
            }

            if (remainBlock == 0) {
                return false;
            }

        }
        return true;
    }
}
