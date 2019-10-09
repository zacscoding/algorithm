package hash.p42577;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Solution2 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (int i = 0; i < phone_book.length - 1; i++) {
            String s1 = phone_book[i];
            int len = s1.length();
            int h = s1.hashCode();

            for (int j = i + 1; j < phone_book.length; j++) {
                String s2 = phone_book[j].substring(0, len);

                if (h != s2.hashCode()) {
                    continue;
                }

                if (s1.equals(s2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
