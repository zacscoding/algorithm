package algorithm.easy.p20;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().isValid("()")
        );
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            Character ch = chars[i];
            Character open = getOpen(ch);
            if (open == null) { // open
                stack.push(ch);
            } else { // close
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pop().equals(open)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
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

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            char required = 0;
            boolean isOpen = false;
            switch (ch) {
                case '(':
                    isOpen = true;
                    required = ')';
                    break;
                case '{':
                    isOpen = true;
                    required = '}';
                    break;
                case '[':
                    isOpen = true;
                    required = ']';
                    break;
                case ')':
                    required = '(';
                    break;
                case '}':
                    required = '{';
                    break;
                case ']':
                    required = '[';
                    break;
            }
            if (isOpen) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top != required) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
