package chap.basic.greedy.p2875;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/2875
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int k = Reader.nextInt();

        int answer = 0;

        while (n >= 2 && m >= 1 && n + m >= k + 3) {
            n -= 2;
            m -= 1;
            answer++;
        }

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
