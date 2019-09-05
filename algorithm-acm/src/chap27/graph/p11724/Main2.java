package chap27.graph.p11724;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/11724
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        String data = "6 8\n"
                      + "1 2\n"
                      + "2 5\n"
                      + "5 1\n"
                      + "3 4\n"
                      + "4 6\n"
                      + "5 4\n"
                      + "2 4\n"
                      + "2 3";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        int N = Reader.nextInt();
        int M = Reader.nextInt();
        boolean[] visited = new boolean[N + 1];

        ArrayList<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();
            g[v1].add(v2);
            g[v2].add(v1);
        }

        int answer = 0;

        for (int start = 1; start <= N; start++) {
            Queue<Integer> que = new LinkedList<>();
            if (visited[start]) {
                continue;
            }

            answer++;
            que.offer(start);
            visited[start] = true;
            while (!que.isEmpty()) {
                int x = que.poll();
                for (int i = 0; i < g[x].size(); i++) {
                    int y = g[x].get(i);
                    if (visited[y] == false) {
                        visited[y] = true;
                        que.offer(y);
                    }
                }
            }
        }

        System.out.println(answer);
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