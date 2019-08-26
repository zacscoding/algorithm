package chap.basic.bruteforce.p1107;

import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import sun.security.util.Length;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1107
 */
public class Main1 {

    static boolean[] b = new boolean[10];

    public static void main(String[] args) throws IOException {
        String data = "101\n"
                      + "1\n"
                      + "9";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        int N = Reader.nextInt();
        int M = Reader.nextInt();

        for (int i = 0; i < M; i++) {
            b[Reader.nextInt()] = true;
        }

        int answer = N - 100;
        if (answer < 0) {
            answer *= -1;
        }

        for (int i = 0; i <= 1000000; i++) {
            int len = possible(i);

            if (len == 0) {
                continue;
            }

            int count = len + Math.abs(N - i);
            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }

    // possible => len | impossible => 0
    static int possible(int n) {
        if (n == 0) {
            return b[0] ? 0 : 1;
        }

        int len = 0;

        while (n > 0) {
            if (b[n % 10]) {
                return 0;
            }

            len++;
            n /= 10;
        }

        return len;
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
