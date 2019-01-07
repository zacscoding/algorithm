package chap.basic.p9012;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/9012
 */
public class Main {

    static final char OPEN = '(';
    static final char CLOSE = ')';
    static int T;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        T = Reader.nextInt();

        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            answer.append(solve(Reader.nextLine()));
        }

        System.out.print(answer);
    }

    static String solve(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == OPEN) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != OPEN) {
                    return "NO\n";
                }
            }
        }

        return stack.isEmpty() ? "YES\n" : "NO\n";
    }

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        public static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public static String nextLine() throws IOException {
            return reader.readLine();
        }

        public static String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public static void close() {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
