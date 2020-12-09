package kakaoblind.b2018.p1;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        System.out.println(9 | 30);
        System.out.println(Integer.toBinaryString(9 | 30));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            String a = Integer.toBinaryString(arr1[i] | arr2[i]);
            StringBuilder builder = new StringBuilder(n);
            for (int j = 0; j < n - a.length(); j++) {
                builder.append(' ');
            }
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == '1') {
                    builder.append('#');
                } else {
                    builder.append(' ');
                }
            }
            ret[i] = builder.toString();
        }
        return ret;
    }
}
