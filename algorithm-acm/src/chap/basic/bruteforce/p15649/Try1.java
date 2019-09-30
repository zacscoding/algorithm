package chap.basic.bruteforce.p15649;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/15649
 */
public class Try1 {

    static boolean[] used = new boolean[10];
    static int[] a = new int[10];
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        answer = new StringBuilder(n * (n - 1) * m * 2);
        solve(0, n, m);
        System.out.print(answer);
    }

    static void solve(int idx, int n, int m) {
        if (idx == m) {
            for (int i = 0; i < m - 1; i++) {
                answer.append(a[i])
                      .append(' ');
            }
            answer.append(a[m - 1]).append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            a[idx] = i;
            solve(idx + 1, n, m);
            used[i] = false;
        }
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
