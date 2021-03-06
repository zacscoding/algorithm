package chap.basic.p17298;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/17298
 */
public class Try1 {

    static int N;
    static Input[] a;

    public static void main(String[] args) throws IOException {
        String data = "2\n"
                      + "3 5";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        N = Reader.nextInt();
        Stack<Input> stack = new Stack<>();
        a = new Input[N];

        for (int i = 0; i < N; i++) {
            int v = Reader.nextInt();
            a[i] = new Input(v);
        }

        stack.push(a[0]);

        Input elt, next;

        for (int i = 1; i < N; i++) {
            next = a[i];

            if (!stack.isEmpty()) {
                elt = stack.pop();

                while (elt.val < next.val) {
                    elt.nge = next.val;

                    if (stack.isEmpty()) {
                        break;
                    }


                    elt = stack.pop();
                }

                if (elt.val > next.val) {
                    stack.push(elt);
                }
            }

            stack.push(next);
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
        int val;
        int nge = -1;

        public Input(int val) {
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
