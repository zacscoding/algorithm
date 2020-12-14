package algorithm.medium.p17;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution2 {
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
                new Solution2().letterCombinations("23").stream().collect(Collectors.joining(","))
        );
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> answers = new ArrayList<>();
        char[] answer = new char[digits.length()];
        solve(answers, digits, 0, answer);
        return answers;
    }

    public void solve(List<String> answers, String digits, int current, char[] answer) {
        if (digits.length() - 1 == current) {
            Character[] letters = dic.get(digits.charAt(current));
            for (Character letter : letters) {
                answer[current] = letter;
                answers.add(new String(answer));
            }
            return;
        }

        Character[] letters = dic.get(digits.charAt(current));
        for (Character letter : letters) {
            answer[current] = letter;
            solve(answers, digits, current + 1, answer);
        }
    }
}
