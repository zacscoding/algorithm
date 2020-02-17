package chap27.graph.p1260;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1260
 */
public class MainByList3 {

    static int n, m, v;
    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static boolean[] visited2;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        n = Reader.nextInt();
        m = Reader.nextInt();
        v = Reader.nextInt();

        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        visited2 = new boolean[n + 1];
        answer = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();
            g[v1].add(v2);
            g[v2].add(v1);
        }
        for (int i = 1; i <= n; i++) {
            g[i].sort(Integer::compareTo);
        }

        dfs(v);
        answer.append('\n');
        bfs(v);

        System.out.println(answer);
    }

    static void dfs(int x) {
        visited[x] = true;
        answer.append(x).append(' ');

        for (int i = 0; i < g[x].size(); i++) {
            int v = g[x].get(i);
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(x);
        visited2[x] = true;
        answer.append(x).append(' ');

        while (!que.isEmpty()) {
            int v1 = que.poll();

            for (int i = 0; i < g[v1].size(); i++) {
                int v2 = g[v1].get(i);

                if (!visited2[v2]) {
                    visited2[v2] = true;
                    que.offer(v2);
                    answer.append(v2).append(' ');
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
