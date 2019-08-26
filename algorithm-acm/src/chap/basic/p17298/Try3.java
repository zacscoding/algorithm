package chap.basic.p17298;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/17298
 */
public class Try3 {

    static int N;
    static Input[] a;

    public static void main(String[] args) throws IOException {
        String data = "4\n"
                      + "9 5 4 8";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        N = Reader.nextInt();
        Stack<Input> stack = new Stack<>();
        a = new Input[N];

        for (int i = 0; i < N; i++) {
            int v = Reader.nextInt();
            a[i] = new Input(i, v);
        }

        stack.push(a[0]);

        for (int i = 1; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(a[i]);
                continue;
            }

            if (stack.peek().val > a[i].val) {
                stack.push(a[i]);
                continue;
            }

            while (!stack.isEmpty()) {
                if (stack.peek().val > a[i].val) {
                    break;
                }

                stack.pop().nge = a[i].val;
            }

            stack.push(a[i]);
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            answer.append(a[i].nge);

            if (i != N - 1) {
                answer.append(' ');
            }
        }

        System.out.println(answer);
    }

    static class Input {
        int idx;
        int val;
        int nge = -1;

        public Input(int idx, int val) {
            this.idx = idx;
            this.val = val;
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
