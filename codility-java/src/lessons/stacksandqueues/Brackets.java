package lessons.stacksandqueues;

import java.util.*;

public class Brackets {
    public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : chars) {
            Character open = getOpen(ch);
            if (open == null) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                if (stack.pop() != open) {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public Character getOpen(char ch) {
        switch (ch) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }
        return null;
    }
}
