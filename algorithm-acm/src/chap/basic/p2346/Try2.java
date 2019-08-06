package chap.basic.p2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2346
 */
public class Try2 {

    public static void main(String[] args) throws IOException {
        // 6
        // 3 2 -1 -5 -5 -3
        Reader.init(System.in);
        int N = Reader.nextInt();

        List<Pair> list = new LinkedList<>();
        StringBuilder answer = new StringBuilder(2 * N);

        for (int i = 0; i < N; i++) {
            int v = Reader.nextInt();
            list.add(new Pair(i + 1, v));
        }

        int idx = 0;

        for (int i = 0; i < N; i++) {
            int removedIdx = idx;
            int size = list.size();
            Pair removed = list.remove(removedIdx);
            answer.append(removed.first);

            if (i != N - 1) {
                answer.append(' ');
            }

            int delta = removed.second;

            if (removed.second < 0) {
                delta = (size + (delta % size)) % size;
            }

            if (delta == 0) {
                idx++;
            } else {
                idx = (idx + delta) % size;
            }

            if (idx > removedIdx) {
                idx--;
            }
        }

        System.out.println(answer);
    }

    static class Pair {

        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
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
