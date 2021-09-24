package algorithm.easy.p937;

import java.util.*;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 * 2 ms	/ 38.9 MB
 */
public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<LettersLog> lettersQueue = new PriorityQueue<>(logs.length);
        List<String> digitLogs = new ArrayList<>(logs.length);

        for (String log : logs) {
            // split to identifier, contents
            int idx = log.indexOf(' ');
            String identifier = log.substring(0, idx);
            String contents = log.substring(idx + 1);

            // check letters-logs or digit-logs
            if (isDigitLogs(contents)) {
                digitLogs.add(log);
                continue;
            }
            lettersQueue.offer(new LettersLog(log, identifier, contents));
        }

        String[] ret = new String[logs.length];
        int idx = 0;
        while (!lettersQueue.isEmpty()) {
            LettersLog log = lettersQueue.poll();
            ret[idx++] = log.origin;
        }

        for (String log : digitLogs) {
            ret[idx++] = log;
        }
        return ret;
    }

    static boolean isDigitLogs(String log) {
        for (int i = 0; i < log.length(); i++) {
            char ch = log.charAt(i);
            if (ch != ' ' && !Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    static class LettersLog implements Comparable<LettersLog> {
        String origin;
        String identifier;
        String contents;

        public LettersLog(String origin, String identifier, String contents) {
            this.origin = origin;
            this.identifier = identifier;
            this.contents = contents;
        }

        @Override
        public int compareTo(LettersLog o) {
            int cmp = contents.compareTo(o.contents);
            if (cmp != 0) {
                return cmp;
            }
            return identifier.compareTo(o.identifier);
        }
    }

    public static void main(String[] args) {
        // String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        String[] logs = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };
        String[] results = new Solution().reorderLogFiles(logs);
        System.out.println(Arrays.toString(results));
    }
}
