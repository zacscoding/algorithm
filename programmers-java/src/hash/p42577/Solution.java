package hash.p42577;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Solution {
    public static void main(String[] args) {
        String[] p = { "12", "123", "1235", "567", "88" };
        new Solution().solution(p);
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (int i = 0; i < phone_book.length - 1; i++) {
            String s1 = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                String s2 = phone_book[j];
                if (s1.length() == s2.length()) {
                    if (s1.hashCode() != s2.hashCode()) {
                        continue;
                    }

                    if (s1.equals(s2)) {
                        return false;
                    }
                } else {
                    if (s2.startsWith(s1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
