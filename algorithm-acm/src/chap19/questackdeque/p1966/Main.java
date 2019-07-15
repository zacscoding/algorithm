package chap19.questackdeque.p1966;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class Main {

    static int[] priorities = new int[101];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int test_case = Reader.nextInt();

        StringBuilder answer = new StringBuilder();
        while (test_case-- > 0) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Deque<Integer> deque = new LinkedList<>();
            int N = Reader.nextInt();
            int M = Reader.nextInt();

            for (int i = 0; i < N; i++) {
                Integer p = Reader.nextInt();
                priorities[i] = p;
                deque.addLast(i);
                priorityQueue.offer(p);
            }

            int c = 1;

            while (true) {
                int t = deque.removeFirst();

                if (priorities[t] == priorityQueue.peek()) {
                    if (M == t) {
                        answer.append(c).append('\n');
                        break;
                    }
                    priorityQueue.poll();
                    c++;
                } else {
                    deque.addLast(t);
                }
            }
        }

        System.out.println(answer);
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
