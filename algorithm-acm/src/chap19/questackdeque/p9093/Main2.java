package chap19.questackdeque.p9093;

import java.io.*;
import java.util.*;

/**
 * Stack
 * https://www.acmicpc.net/problem/9093
 */
public class Main2 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        String data = "2\n"
                      + "I am happy today\n"
                      + "We want to win the first prize";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        int T = Reader.nextInt();

        StringBuilder answer = new StringBuilder(20000);

        while (T-- > 0) {
            char[] line = Reader.nextLine().toCharArray();
            for (int i = 0; i < line.length; i++) {
                char ch = line[i];

                if (ch == ' ') {
                    while (!stack.isEmpty()) {
                        answer.append(stack.pop());
                    }
                    answer.append(ch);
                } else if (i == line.length - 1) {
                    stack.push(ch);
                    while (!stack.isEmpty()) {
                        answer.append(stack.pop());
                    }
                } else {
                    stack.push(ch);
                }
            }

            answer.append('\n');
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
