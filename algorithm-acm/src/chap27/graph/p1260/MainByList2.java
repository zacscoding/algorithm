package chap27.graph.p1260;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1260
 */
public class MainByList2 {

    static int N, M, V;
    static ArrayList<Integer>[] g;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        String data = "5 5 3\n"
                      + "5 4\n"
                      + "5 2\n"
                      + "1 2\n"
                      + "3 4\n"
                      + "3 1";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        N = Reader.nextInt();
        M = Reader.nextInt();
        V = Reader.nextInt();

        g = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();
            g[v1].add(v2);
            g[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(g[i]);
        }

        StringBuilder answer = new StringBuilder(N * 3);
        // dfs
        dfs(answer, V);
        answer.append("\n");
        visited = new boolean[N + 1];
        bfs(answer, V);
        answer.append("\n");
        System.out.println(answer);
    }

    static void dfs(StringBuilder answer, int v) {
        visited[v] = true;
        answer.append(v).append(" ");

        for (int i = 0; i < g[v].size(); i++) {
            int next = g[v].get(i);
            if (visited[next] == false) {
                dfs(answer, next);
            }
        }
    }

    static void bfs(StringBuilder answer, int v) {
        Queue<Integer> que = new LinkedList<>();
        visited[v] = true;
        que.offer(v);
        answer.append(v).append(" ");

        while (!que.isEmpty()) {
            int current = que.poll();
            for (int i = 0; i < g[current].size(); i++) {
                int x = g[current].get(i);
                if (visited[x] == false) {
                    visited[x] = true;
                    que.offer(x);
                    answer.append(x).append(" ");
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
