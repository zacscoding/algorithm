package chap27.graph.p2178;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/2178
 */
public class Try1 {

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int N = Reader.nextInt();
        int M = Reader.nextInt();
        int[][] g = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = Reader.nextLine().trim();
            for (int j = 0; j < line.length(); j++) {
                g[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!que.isEmpty()) {
            Pair pair = que.poll();

            for (int i = 0; i < dy.length; i++) {
                int y = pair.first + dy[i];
                int x = pair.second + dx[i];

                if (y >= 0 && y < N && x >= 0 && x < M) {
                    if (visited[y][x] == false && g[y][x] == 1) {
                        que.offer(new Pair(y, x));
                        visited[y][x] = true;
                        dist[y][x] = dist[pair.first][pair.second] + 1;
                    }
                }
            }
        }
        System.out.println(dist[N - 1][M - 1]);
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
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
