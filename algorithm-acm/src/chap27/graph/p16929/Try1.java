package chap27.graph.p16929;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/16929
 */
public class Try1 {

    final static int[] dx = { 0, 0, 1, -1 };
    final static int[] dy = { 1, -1, 0, 0 };

    static int N, M;
    static char[][] a;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        N = Reader.nextInt();
        M = Reader.nextInt();
        a = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            a[i] = Reader.nextLine().trim().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (dfs(-1, -1, i, j, a[i][j])) {
                    System.out.println("Yes");
                    System.exit(0);
                }

            }
        }
        System.out.println("No");
    }

    static boolean dfs(int y1, int x1, int y2, int x2, char color) {
        if (visited[y2][x2]) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int y3 = y2 + dy[k];
            int x3 = x2 + dx[k];

            if (y3 >= 0 && y3 < N && x3 >= 0 && x3 < M) {
                if (!(y3 == y1 && x3 == x1) && a[y3][x3] == color) {
                    if (dfs(y2, x2, y3, x3, color)) {
                        return true;
                    }
                }
            }
        }

        return false;
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
