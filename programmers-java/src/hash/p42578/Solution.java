package hash.p42578;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class Solution {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            int count = map.computeIfAbsent(type, k -> 0);
            map.put(type, count + 1);
        }

        int answer = 1;

        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
