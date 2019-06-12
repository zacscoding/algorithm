package chap19.questackdeque.p10845;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10845
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int N = Reader.nextInt();
        Deque<Integer> que = new LinkedList<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String cmd = Reader.next().trim();
            switch (cmd) {
                case "push":
                    que.addLast(Reader.nextInt());
                    break;
                case "pop":
                    answer.append(que.isEmpty() ? -1 : que.removeFirst())
                        .append("\n");
                    break;
                case "size":
                    answer.append(que.size())
                        .append("\n");
                    break;
                case "empty":
                    answer.append(que.isEmpty() ? 1 : 0)
                        .append("\n");
                    break;
                case "front":
                    answer.append(que.isEmpty() ? -1 : que.getFirst())
                        .append("\n");
                    break;
                case "back":
                    answer.append(que.isEmpty() ? -1 : que.getLast())
                        .append("\n");
                    break;
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
