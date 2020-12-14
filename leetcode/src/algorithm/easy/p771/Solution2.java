package algorithm.easy.p771;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class Solution2 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jSet = new HashSet<>((int) (J.length() * 1.2), 0.99999F);
        for (int i = 0; i < J.length(); i++) {
            jSet.add(J.charAt(i));
        }

        int answer = 0;
        char[] sChars = S.toCharArray();
        for (char c : sChars) {
            if (jSet.contains(c)) {
                answer++;
            }
        }
        return answer;
    }
}
