package chap.basic.p2751;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/
 */
public class Main {

    static int N;
    static PriorityQueue<Integer> que = new PriorityQueue<>(1000000);

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        N = Reader.nextInt();

        for (int i = 0; i < N; i++) {
            que.offer(Reader.nextInt());
        }

        StringBuilder sb = new StringBuilder();

        while (!que.isEmpty()) {
            sb.append(que.poll()).append("\n");
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
