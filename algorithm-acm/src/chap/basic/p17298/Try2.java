package chap.basic.p17298;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/17298
 */
public class Try2 {

    static int N;
    static Pair[] p;
    static int[] indices;

    public static void main(String[] args) throws IOException {
        String data = "4\n"
                      + "9 5 4 8";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        N = Reader.nextInt();
        p = new Pair[N];
        indices = new int[N];

        for (int i = 0; i < N; i++) {
            int val = Reader.nextInt();
            p[i] = new Pair(val, i);
        }

        Arrays.sort(p, (o1, o2) -> -(o1.value - o2.value));

        for (int i = 0; i < N; i++) {
            indices[p[i].idx] = i;
        }

        StringBuilder answer = new StringBuilder(N * 2);

        for (int i = 0; i < N; i++) {
            int target = -1;
            int start = indices[i];
            for (int j = start - 1; j >= 0; j--) {
                if (p[j].idx > i) {
                    target = p[j].value;
                    break;
                }
            }
            answer.append(target);
            if (i != N - 1) {
                answer.append(' ');
            }
        }

        System.out.println(answer);
    }

    static class Pair {
        int value;
        int idx;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
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
