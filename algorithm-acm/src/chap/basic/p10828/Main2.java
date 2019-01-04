package chap.basic.p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class Main2 {

    static int N;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        N = Reader.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String cmd = Reader.next();

            switch (cmd) {
                case "push":
                    stack.push(Reader.nextInt());
                    continue;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size":
                    sb.append(stack.size());
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek());
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
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
