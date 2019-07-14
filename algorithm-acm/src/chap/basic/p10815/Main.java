package chap.basic.p10815;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/10815
 */
public class Main {

    static Set<Integer> set = new HashSet<>((int) (500000 * 1.5), 0.999999F);

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int N = Reader.nextInt();
        for (int i = 0; i < N; i++) {
            set.add(Reader.nextInt());
        }

        StringBuilder answer = new StringBuilder();
        int M = Reader.nextInt();

        for (int i = 1; i <= M; i++) {
            char has = set.contains(Reader.nextInt()) ? '1' : '0';
            answer.append(has);
            if (i != M) {
                answer.append(' ');
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
