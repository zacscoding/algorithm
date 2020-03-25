package sort.p42746;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
class Failure {

    public static void main(String[] args) {
//        System.out.println(
//                new Solution().solution(new int[] { 6, 10, 2 })
//        );
//        System.out.println(
//                new Solution().solution(new int[] { 3, 30, 34, 5, 9 })
//        );
        System.out.println(
                new Failure().solution(new int[] { 35, 3519 })
        );
        System.out.println(
                new Failure().solution(new int[] { 34, 3411 })
        );
        System.out.println(
                new Failure().solution(new int[] { 34, 3452 })
        );
    }

    public String solution(int[] numbers) {
        String[] numValues = new String[numbers.length];
        int len = 0;
        for (int i = 0; i < numbers.length; i++) {
            numValues[i] = String.valueOf(numbers[i]);
            len += numValues[i].length();
        }

        StringBuilder answer = new StringBuilder(len);
        Arrays.sort(numValues, (o1, o2) -> {
            boolean reverse = o1.length() > o2.length();

            if (reverse) {
                String t = o1;
                o1 = o2;
                o2 = t;
            }

            for (int i = 0; i < o1.length(); i++) {
                char c1 = o1.charAt(i);
                char c2 = o2.charAt(i);

                if (c1 == c2) {
                    continue;
                }

                int ret = c1 > c2 ? -1 : 1;
                if (reverse) {
                    ret *= -1;
                }

                return ret;
            }

            if (o1.length() == o2.length()) {
                return 0;
            }

            for (int i = o1.length(); i < o2.length(); i++) {

            }

            int ret = o2.charAt(o1.length()) > o2.charAt(0) ? 1 : -1;
            if (reverse) {
                ret *= -1;
            }
            return ret;
        });

        for (String numValue : numValues) {
            answer.append(numValue);
        }

        return answer.toString();
    }
}