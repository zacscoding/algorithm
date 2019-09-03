package chap.basic.p6064;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/6064
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        String data = "3\n"
                      + "10 12 3 9\n"
                      + "10 12 7 2\n"
                      + "13 11 5 6";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        int T = Reader.nextInt();
        while (T-- > 0) {
            int M = Reader.nextInt();
            int N = Reader.nextInt();
            int x = Reader.nextInt() - 1;
            int y = Reader.nextInt() - 1;

            boolean found = false;
            int l = lcd(M, N);
            for (int k = x; k <= l; k += M) {
                if (k % N == y) {
                    System.out.println(k + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(-1);
            }
        }
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    static int lcd(int a, int b) {
        int g = gcd(a, b);
        return g * (a / g) * (b / g);
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
