package chap.basic.bruteforce.p1476;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1476
 */
public class Main1 {

    static final int m1 = 15;
    static final int m2 = 28;
    static final int m3 = 19;

    public static void main(String[] args) throws IOException {
        String data = "15 28 19";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        int E = Reader.nextInt() % m1;
        int S = Reader.nextInt();
        int M = Reader.nextInt() % m3;

        for (int i = 0; ; i++) {
            int k = S + (m2 * i);

            if (k % m1 == E && k % m3 == M) {
                System.out.println(k);
                break;
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
