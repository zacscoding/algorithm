package hash.p42576;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Solution {

    public static void main(String[] args) {
        String[] p = { "mislav", "stanko", "mislav", "ana" };
        String[] c = { "stanko", "ana", "mislav" };

        System.out.println(new Solution().solution(p, c));
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            Integer count = map.get(p);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(p, count);
        }

        for (String c : completion) {
            int count = map.get(c);
            if (count == 1) {
                map.remove(c);
            } else {
                map.put(c, --count);
            }
        }

        return map.keySet().iterator().next();
    }
}
