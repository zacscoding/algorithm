package algorithm.easy.p125;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * 3 ms	/ 39.1 MB
 */
public class SolutionByReverse {
    public boolean isPalindrome(String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append(Character.toLowerCase(ch));
                continue;
            }
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                result.append(ch);
            }
        }

        String origin = result.toString();
        String reverse = result.reverse().toString();

        return origin.isEmpty() || origin.equals(reverse);
    }
}
