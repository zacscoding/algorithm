package hash.p42578;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Failure {
    public static void main(String[] args) {
        System.out.println(
                new Failure().solution(
                        new String[][] {
                                { "yellow_hat", "headgear" },
                                { "blue_sunglasses", "eyewear" },
                                { "green_turban", "headgear" }
                        }
                )
        );

//        System.out.println(
//                new Solution().solution(
//                        new String[][] {
//                                { "crow_mask", "face" },
//                                { "blue_sunglasses", "face" },
//                                { "smoky_makeup", "face" }
//                        }
//                )
//        );
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            int count = map.computeIfAbsent(type, k -> 0);
            map.put(type, count + 1);
        }

        int[] counts = new int[map.size()];
        int idx = 0;
        for (Integer value : map.values()) {
            counts[idx++] = value;
        }
        boolean[] include = new boolean[map.size()];

        return solve(counts, include, 0);
    }

    int solve(int[] counts, boolean[] includes, int start) {
        if (counts.length - 1 == start) {
            // 1) contains
            int t = 0;
            int c = 1;
            for (int i = 0; i < counts.length - 1; i++) {
                if (includes[i]) {
                    c *= counts[i];
                }
            }
            c *= counts[counts.length - 1];
            t += c;

            // 2) not contains
            boolean b = false;
            for (int i = 0; i < counts.length; i++) {
                if (includes[i]) {
                    b = true;
                    break;
                }
            }

            if (b) {
                t += c / counts[counts.length - 1];
            }

            return t;
        }

        includes[start] = true;
        int t = solve(counts, includes, start + 1);
        includes[start] = false;
        t += solve(counts, includes, start + 1);

        return t;
    }
}