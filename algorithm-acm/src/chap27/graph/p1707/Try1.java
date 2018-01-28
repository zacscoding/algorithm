package chap27.graph.p1707;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1707
 *
 * @author zacconding
 * @Date 2018-01-28
 * @GitHub : https://github.com/zacscoding
 */
public class Try1 {

    public static int[][] adj;
    public static int V, E;
    public static int[] color;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int T = Reader.nextInt();
        while (T-- > 0) {
            V = Reader.nextInt();
            E = Reader.nextInt();
            adj = new int[V + 1][V + 1];
            color = new int[V + 1];
            for (int i = 0; i < E; i++) {
                int a = Reader.nextInt();
                int b = Reader.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    dfs(i, 1);
                }
            }

            System.out.println(solve() ? "YES" : "NO");
        }
    }

    public static boolean solve() {
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (adj[i][j] == 1 && color[i] == color[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void dfs(int visit, int c) {
        color[visit] = c;
        for (int i = 1; i <= V; i++) {
            if (adj[visit][i] == 1 && color[i] == 0) {
                dfs(i, 3 - c);
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
