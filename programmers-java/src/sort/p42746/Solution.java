package sort.p42746;

import java.util.Arrays;

/**
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(new int[] { 6, 10, 2 })
        );
        System.out.println(
                new Solution().solution(new int[] { 3, 30, 34, 5, 9 })
        );
        System.out.println(
                new Solution().solution(new int[] { 0, 0 })
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
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return -s1.compareTo(s2);
        });

        for (String numValue : numValues) {
            answer.append(numValue);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}
