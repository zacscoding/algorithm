package chap17.partialsum.p1806;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1806
 */
public class Main1 {

    static int N;
    static int S;
    static int[] psum = new int[100001];
    static int[] seq;

    public static void main(String[] args) throws IOException {
        String data = "";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);
        N = Reader.nextInt();
        S = Reader.nextInt();
        seq = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            seq[i] = Reader.nextInt();
            psum[i] = psum[i - 1] + seq[i];
        }

        if (psum[N] < S) {
            System.out.println(0);
        } else if (psum[N] == S) {
            System.out.println(N);
        } else {
            int l = -1;
            boolean found = false;
            while (l < N) {
                l++;
                for (int i = 1; i <= N - l; i++) {
                    if (rangeSum(i, i + l) >= S) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    break;
                }
            }
            System.out.println(l + 1);
        }
    }

    static int rangeSum(int a, int b) {
        if (a == b) {
            return seq[a];
        }

        if (a == 1) {
            return psum[b];
        }

        return psum[b] - psum[a - 1];
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
