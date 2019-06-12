package chap19.questackdeque.p2164;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2164
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int N = Reader.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (deque.size() > 1) {
            deque.removeFirst();

            if (deque.size() <= 1) {
                break;
            }

            Integer s = deque.removeFirst();
            deque.addLast(s);
        }

        System.out.println(deque.poll());
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
