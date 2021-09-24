package algorithm.easy.p344;

/**
 * https://leetcode.com/problems/reverse-string/
 * 1 ms	/ 46 MB
 */
public class Solution {

    public void reverseString(char[] s) {
        int len = s.length / 2;
        for (int i = 0; i < len; i++) {
            int ridx = s.length - i - 1;
            char t = s[i];
            s[i] = s[ridx];
            s[ridx] = t;
        }
    }

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        new Solution().reverseString(s);
        System.out.println(s);
    }
}
