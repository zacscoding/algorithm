package chap27.graph.p2667;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2667
 *
 * @author zaccoding
 * github : https://github.com/zacscoding
 */
public class Try1 {

    public static int N;
    public static int[][] a;
    public static int start = 2;
    private final int[] DY = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private final int[] DX = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        N = Reader.nextInt();
        a = new int[N][];
        for (int i = 0; i < N; i++) {
            a[i] = new int[N];
            String line = Reader.next();
            for (int j = 0; j < N; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 1) {
                    // start 숫자 카운팅 ++
                    find(i, j, start++);
                }
            }
        }
    }

    public static void find(int x, int y, int number) {
        if (isRange(x, y)) {

        }
    }

    private static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }

        return true;
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
