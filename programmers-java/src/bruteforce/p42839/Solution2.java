package bruteforce.p42839;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(
                new Solution2().solution("17")
        );
//        System.out.println(
//                new Solution().solution("011")
//        );
    }

    public int solution(String numbers) {
        int answer = 0;

        for (int i = 1; i <= numbers.length(); i++) {
            answer += solve(0, i, numbers, "");
        }

        return answer;
    }

    public int solve(int idx, int n, String numbers, String number) {
        if (n == 0) {
            System.out.println("Check " + number);
            if (isPrime(Integer.parseInt(number))) {
                return 1;
            }

            return 0;
        }

        if (idx >= numbers.length()) {
            return 0;
        }

        int answer1 = solve(idx + 1, n - 1, numbers, number + numbers.charAt(idx));
        int answer2 = solve(idx + 1, n, numbers, number);

        return answer1 + answer2;
    }

    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
