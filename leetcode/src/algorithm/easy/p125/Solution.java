package algorithm.easy.p125;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * 2 ms	/ 39 MB
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = extractAlphaNumeric(s);
        if (s.isEmpty()) {
            return true;
        }
        return checkPalindrome(s);
    }

    public static String extractAlphaNumeric(String s) {
        StringBuilder result = new StringBuilder(s.length());
        int upperLowerGap = 'a' - 'A';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) (ch + upperLowerGap));
                continue;
            }
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                result.append(ch);
            }
        }
        return result.toString();
    }

//    public static String extractAlphaNumeric(String s) {
//        StringBuilder result = new StringBuilder(s.length());
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
//                result.append(Character.toLowerCase(ch));
//            }
//        }
//        return result.toString();
//    }

    public static boolean checkPalindrome(String s) {
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            char cur = s.charAt(i);
            char comp = s.charAt(s.length() - i - 1);
            if (cur != comp) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] examples = {
                "A man, a plan, a canal: Panama",
                "race a car",
                " "
        };

        for (String example : examples) {
            System.out.println("Check: " + example + " >> " + new Solution().isPalindrome(example));
        }
    }
}
