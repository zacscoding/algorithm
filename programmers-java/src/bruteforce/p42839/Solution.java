package bruteforce.p42839;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution("17")
        );
    }

    public int solution(String numbers) {
        Set<Integer> answers = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            char[] chars = numbers.toCharArray();
            perm(answers, chars, 0, numbers.length(), i);
        }

        return answers.size();
    }

    void perm(Set<Integer> answers, char[] arr, int depth, int n, int r) {
        if (depth == r) {
            if (arr[0] == '0') {
                return;
            }

            int number = 0;
            int tenPow = 1;

            for (int i = r - 1; i >= 0; i--) {
                number += Character.digit(arr[i], 10) * tenPow;
                tenPow *= 10;
            }

            if (!answers.contains(number)) {
                if (isPrime(number)) {
                    answers.add(number);
                }
            }

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            perm(answers, arr, depth + 1, n, r);
            swap(arr, i, depth);
        }
    }

    void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
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
