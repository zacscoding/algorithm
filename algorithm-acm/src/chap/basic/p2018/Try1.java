package chap.basic.p2018;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2018
 */
public class Try1 {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int count = 0;

        for (int i = 1; (i * (i + 1)) / 2 <= n; i++) {
            if (i % 2 == 1) {
                if (n % i == 0) {
                    count++;
                }
            } else {
                if (n % i == i / 2) {
                    count++;
                }
            }
        }
        System.out.print(count);
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
