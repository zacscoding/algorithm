package chap.basic.bruteforce.p1476;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1476
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        String data = "1 2 3";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);
        int E = Reader.nextInt() % 15;
        int S = Reader.nextInt() % 28;
        int M = Reader.nextInt() % 19;
        int e = 1, s = 1, m = 1;

        for (int i = 1; ; i++) {
            if (i % 15 == E && i % 28 == S && i % 19 == M) {
                System.out.println(i);
                break;
            }

            e += 1;
            s += 1;
            m += 1;

            if (e == 16) {
                e = 1;
            }

            if (s == 28) {
                s = 1;
            }

            if (m == 19) {
                m = 1;
            }
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
