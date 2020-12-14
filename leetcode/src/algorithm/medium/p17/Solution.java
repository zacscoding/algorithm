package algorithm.medium.p17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    static Map<Character, Character[]> dic = new HashMap<>();

    static {
        dic.put('2', new Character[] { 'a', 'b', 'c' });
        dic.put('3', new Character[] { 'd', 'e', 'f' });
        dic.put('4', new Character[] { 'g', 'h', 'i' });
        dic.put('5', new Character[] { 'j', 'k', 'l' });
        dic.put('6', new Character[] { 'm', 'n', 'o' });
        dic.put('7', new Character[] { 'p', 'q', 'r', 's' });
        dic.put('8', new Character[] { 't', 'u', 'v' });
        dic.put('9', new Character[] { 'w', 'x', 'y', 'z' });
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().letterCombinations("32").stream().collect(Collectors.joining(","))
        );
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> answers = new ArrayList<>();
        dfs(answers, digits, 0, new StringBuilder(digits.length()));
        return answers;
    }

    public void dfs(List<String> answers, String digits, int index, StringBuilder path) {
        if (path.length() == digits.length()) {
            answers.add(path.toString());
            return;
        }
        Character[] chars = dic.get(digits.charAt(index));
        for (Character c : chars) {
            dfs(answers, digits, index + 1, new StringBuilder(path).append(c));
        }
    }
}
