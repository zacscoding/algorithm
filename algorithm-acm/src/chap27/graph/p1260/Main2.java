package chap27.graph.p1260;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1260
 */
public class Main2 {

    static int N, M, V;
    static int[][] g;
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

        g = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();
            g[v1][v2] = 1;
            g[v2][v1] = 1;
        }

        StringBuilder answer = new StringBuilder();
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
        for (int i = 1; i <= N; i++) {
            if (g[v][i] != 0 && visited[i] == false) {
                dfs(answer, i);
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
            for (int i = 1; i <= N; i++) {
                if (g[current][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    answer.append(i).append(" ");
                    que.offer(i);
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
