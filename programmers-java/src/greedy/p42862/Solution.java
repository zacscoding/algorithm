package greedy.p42862;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> lostList = new ArrayList<>(lost.length);
        for (int l : lost) {
            lostList.add(l);
        }

        int count = n - lost.length;

        for (int r : reserve) {
            if (lostList.remove(Integer.valueOf(r))) {
                count++;
            } else {
                map.put(r, 1);
            }
        }

        if (lostList.isEmpty()) {
            return count;
        }

        int[] trim = new int[lostList.size()];
        for (int i = 0; i < lostList.size(); i++) {
            trim[i] = lostList.get(i);
        }
        return solve(n, count, trim, 0, map);
    }

    public int solve(int n, int count, int[] lost, int idx, Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            return count;
        }
        if (idx >= lost.length) {
            return count;
        }

        int max = count;
        int target = lost[idx];

        // 앞
        if (target != 1 && map.remove(target - 1) != null) {
            int t = solve(n, count + 1, lost, idx + 1, map);
            map.put(target - 1, 1);

            if (t > max) {
                max = t;
            }
        }

        // 2) 뒤
        if (target != n && map.remove(target + 1) != null) {
            int t = solve(n, count + 1, lost, idx + 1, map);
            map.put(target + 1, 1);

            if (t > max) {
                max = t;
            }
        }
        // 3) 안빌림
        int t = solve(n, count, lost, idx + 1, map);
        if (t > max) {
            max = t;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 })
        );

        System.out.println(
                new Solution().solution(5, new int[] { 2, 4 }, new int[] { 3 })
        );
        System.out.println(
                new Solution().solution(3, new int[] { 3 }, new int[] { 1 })
        );

        System.out.println(
                new Solution().solution(3, new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 })
        );
    }
}
