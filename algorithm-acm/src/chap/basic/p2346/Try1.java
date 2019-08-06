package chap.basic.p2346;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2346
 */
public class Try1 {

    public static void main(String[] args) throws IOException {
        // setup
        Reader.init(System.in);
        int N = Reader.nextInt();
        Deque<Pair> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            que.addLast(new Pair(i + 1, Reader.nextInt()));
        }




    }

    static class Pair {

        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first);
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
