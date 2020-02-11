package chap.basic.greedy.p11047;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/11047
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();
        int k = Reader.nextInt();

        int[] cs = new int[n];
        for (int i = 0; i < n; i++) {
            cs[i] = Reader.nextInt();
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cs[i] > k) {
                continue;
            }

            int t = k / cs[i];
            k -= cs[i] * t;

            count += t;

            if (k == 0) {
                break;
            }
        }

        System.out.println(count);
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
