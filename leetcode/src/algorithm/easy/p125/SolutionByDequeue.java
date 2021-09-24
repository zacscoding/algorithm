package algorithm.easy.p125;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * 3 ms	/ 38.9 MB
 */
public class SolutionByDequeue {

    public boolean isPalindrome(String s) {
        Deque<Character> deque = new ArrayDeque<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isAlphaNumeric(ch)) {
                continue;
            }
            deque.addLast(Character.toLowerCase(ch));
        }

        if (deque.isEmpty()) {
            return true;
        }

        while (!deque.isEmpty()) {
            Character left = deque.pollFirst();
            Character right = deque.pollLast();
            if (right == null) {
                return true;
            }
            if (!left.equals(right)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaNumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z')
               || (ch >= 'a' && ch <= 'z')
               || (ch >= '0' && ch <= '9');
    }

    public static void main(String[] args) {
        String[] examples = {
                "A man, a plan, a canal: Panama",
                "race a car",
                " "
        };

        for (String example : examples) {
            System.out.println("Check: " + example + " >> " + new SolutionByDequeue().isPalindrome(example));
        }
    }
}
