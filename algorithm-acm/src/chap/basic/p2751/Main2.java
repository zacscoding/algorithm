package chap.basic.p2751;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/
 */
public class Main2 {

    static int N;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        N = Reader.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Reader.nextInt();
        }

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append("\n");
        }

        System.out.println(sb);
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
