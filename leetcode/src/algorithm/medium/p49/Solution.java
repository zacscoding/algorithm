package algorithm.medium.p49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> arr = m.get(key);
            if (arr == null) {
                arr = new ArrayList<>();
                m.put(key, arr);
            }
            arr.add(str);
        }
        return new ArrayList<>(m.values());
    }
}
