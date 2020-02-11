package chap.basic.greedy.p5585;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/5585
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int r = 1000 - Reader.nextInt();
        int[] cs = new int[] { 500, 100, 50, 10, 5 };
        int answer = 0;

        for (int i = 0; i < cs.length; i++) {
            if (r < cs[i]) {
                continue;
            }

            int t = r / cs[i];
            r -= cs[i] * t;
            answer += t;

            if (r == 0) {
                break;
            }
        }

        answer += r;

        System.out.println(answer);
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
