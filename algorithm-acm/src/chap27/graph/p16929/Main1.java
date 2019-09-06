package chap27.graph.p16929;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/16929
 */
public class Main1 {

    final static int[] dx = { 0, 0, 1, -1 };
    final static int[] dy = { 1, -1, 0, 0 };

    static int N, M;
    static char[][] a;
    static int[][] dist;
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
                dist = new int[N][M];
                if (dfs(i, j, 1, a[i][j])) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }

    static boolean dfs(int y, int x, int count, char color) {
        if (visited[y][x]) {
            return count - dist[y][x] >= 4;
        }

        visited[y][x] = true;
        dist[y][x] = count;

        for (int k = 0; k < 4; k++) {
            int y1 = y + dy[k];
            int x1 = x + dx[k];

            if (y1 >= 0 && y1 < N && x1 >= 0 && x1 < M && a[y1][x1] == color) {
                if (dfs(y1, x1, count + 1, color)) {
                    return true;
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
