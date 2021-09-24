package algorithm.easy.p344;

/**
 * https://leetcode.com/problems/reverse-string/
 * 1 ms	/ 46 MB
 */
public class SolutionByTwoPoint {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        new SolutionByTwoPoint().reverseString(s);
        System.out.println(s);
    }
}
