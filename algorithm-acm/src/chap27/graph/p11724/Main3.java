package chap27.graph.p11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/11724
 */
public class Main3 {

    static int n, m;
    static int[][] g;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        n = Reader.nextInt();
        m = Reader.nextInt();
        g = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            int v1 = Reader.nextInt() - 1;
            int v2 = Reader.nextInt() - 1;
            g[v1][v2] = 1;
            g[v2][v1] = 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int i = 0; i < g[start].length; i++) {
            if (g[start][i] == 1 && !visited[i]) {
                dfs(i);
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
