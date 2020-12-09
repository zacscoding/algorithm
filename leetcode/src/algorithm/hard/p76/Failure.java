package algorithm.hard.p76;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Failure {
    public static void main(String[] args) {
        System.out.println(new Failure().minWindow("bbaa", "aba"));
    }

    // Time Limit Exceeded
    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        if (s.length() < t.length()) {
            return "";
        }
        if (t.length() == 1) {
            return s.indexOf(t.charAt(0)) < 0 ? "" : t;
        }
        char[] sChars = s.toCharArray();
        Set<Character> tSet = toSet(t);
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (tSet.contains(sChars[i])) {
                starts.add(i);
            }
        }

        int minStartIdx = 0, minLastIdx = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < starts.size(); i++) {
            int startIdx = starts.get(i);
            Counter counter = new Counter(t);
            counter.dec(sChars[startIdx]);
            for (int j = i + 1; j < starts.size(); j++) {
                int nextIndex = starts.get(j);
                counter.dec(sChars[nextIndex]);
                if (counter.isEmpty()) {
                    int len = nextIndex - startIdx + 1;
                    if (minLen > len) {
                        minStartIdx = startIdx;
                        minLastIdx = nextIndex;
                        minLen = len;
                    }
                    break;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        char[] answer = new char[minLastIdx - minStartIdx + 1];
        System.arraycopy(sChars, minStartIdx, answer, 0, minLastIdx - minStartIdx + 1);
        return new String(answer);
    }

    public Set<Character> toSet(String s) {
        Set<Character> set = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }

    static class Counter {
        Map<Character, Integer> words = new HashMap<>();

        public Counter(String s) {
            for (int i = 0; i < s.length(); i++) {
                inc(s.charAt(i));
            }
        }

        public void inc(Character c) {
            Integer count = words.get(c);
            if (count == null) {
                count = 0;
            }
            words.put(c, count + 1);
        }

        public void dec(char c) {
            Integer count = words.get(c);
            if (count != null) {
                if (count == 1) {
                    words.remove(c);
                } else {
                    words.put(c, count - 1);
                }
            }
        }

        public boolean isEmpty() {
            return words.isEmpty();
        }
    }
}
