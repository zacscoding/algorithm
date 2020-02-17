package chap27.graph.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1260
 */
public class Main3 {

    static int n, m, v;
    static int[][] g;
    static boolean[] visited;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        n = Reader.nextInt();
        m = Reader.nextInt();
        v = Reader.nextInt();

        g = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();
            g[v1][v2] = g[v2][v1] = 1;
        }

        answer = new StringBuilder();
        // dfs
        dfs(v);
        answer.append('\n');
        visited = new boolean[n + 1];
        // bfs
        bfs(v);
        System.out.println(answer);
    }

    static void dfs(int x) {
        visited[x] = true;
        answer.append(x).append(' ');

        for (int i = 1; i < g[x].length; i++) {
            if (g[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        visited[x] = true;
        answer.append(x).append(' ');

        while (!que.isEmpty()) {
            int v = que.poll();

            for (int i = 1; i < g[v].length; i++) {
                if (g[v][i] == 1 && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                    answer.append(i).append(' ');
                }
            }
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
