package chap27.graph.p1260;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1260
 *
 * @author zacconding
 * @Date 2018-01-28
 * @GitHub : https://github.com/zacscoding
 */
public class TryArray {

    public static int[][] adj = new int[10001][10001];
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int N = Reader.nextInt();
        int M = Reader.nextInt();
        int V = Reader.nextInt();
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int a = Reader.nextInt();
            int b = Reader.nextInt();
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        dfs(V);
        System.out.println();
        bfs(V, N);
    }

    public static void dfs(int n) {
        visited[n] = true;
        System.out.print(n + " ");
        for (int i = 0; i < adj[n].length; i++) {
            if (adj[n][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int n, int size) {
        boolean[] visit = new boolean[size + 1];
        Queue<Integer> que = new PriorityQueue<>();
        que.offer(n);
        visit[n] = true;
        System.out.print(n + " ");
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int i = 0; i < adj[x].length; i++) {
                if (adj[x][i] == 1 && !visit[i]) {
                    que.offer(i);
                    visit[i] = true;
                    System.out.print(i + " ");
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
    }
}
