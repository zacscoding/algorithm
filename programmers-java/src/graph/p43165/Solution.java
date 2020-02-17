package graph.p43165;

/**
 */
class Solution {
    public static void main(String[] args) {
        int[] numbers = new int[] { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(
                new Solution().solution(numbers, target)
        );
    }

    public int solution(int[] numbers, int target) {
        int answer = solve(numbers, target, 0, 0);
        return answer;
    }

    public int solve(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            return target == sum ? 1 : 0;
        }

        return solve(numbers, target, idx + 1, sum + numbers[idx])
               + solve(numbers, target, idx + 1, sum - numbers[idx]);
    }
}
