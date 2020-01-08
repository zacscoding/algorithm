package chap.basic.twopoint.p2003;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/2003
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //String data = "";
        // InputStream stream = new ByteArrayInputStream(data.getBytes());
        //System.setIn(stream);
        Reader.init(System.in);

        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Reader.nextInt();
        }

        int start = 0, end = 0, sum = 0, res = 0;

        while (true) {
            if (sum >= m) {
                sum -= a[start++];
            } else if (end == n) {
                break;
            } else {
                sum += a[end++];
            }

            if (sum == m) {
                res++;
            }
        }

        System.out.println(res);
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
