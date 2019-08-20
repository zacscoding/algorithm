package chap19.questackdeque.p1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1874
 */
public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int N = Reader.nextInt();
        int push = 1;
        StringBuilder answer = new StringBuilder();
        boolean impossible = false;

        for (int i = 1; i <= N; i++) {
            if (impossible) {
                Reader.nextInt();
                continue;
            }

            int target = Reader.nextInt();

            if (push == target) {
                answer.append("+\n")
                      .append("-\n");
                push++;
            } else if (push < target) {
                for (int j = push; j < target; j++) {
                    stack.push(j);
                    answer.append("+\n");
                }

                answer.append("+\n")
                      .append("-\n");

                push = target + 1;
            } else {
                if (stack.peek() == target) {
                    stack.pop();
                    answer.append("-\n");
                } else {
                    impossible = true;
                }
            }
        }

        String result = impossible ? "NO" : answer.toString();

        if (result.charAt(result.length() - 1) == '\n') {
            result = result.substring(0, result.length() - 1);
        }

        System.out.println(result);
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
