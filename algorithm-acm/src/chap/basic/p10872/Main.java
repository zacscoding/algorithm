package chap.basic.p10872;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10872
 */
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        N = Reader.nextInt();
        if (N == 0) {
            System.out.println(1);
        } else {
            long answer = 1L;

            for (int i = N; i >= 1; i--) {
                answer *= i;
            }

            System.out.println(answer);
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