package chap27.graph.p4963;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/4963
 */
public class Main2 {

    static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        StringBuilder answer = new StringBuilder();

        for (; ; ) {
            int w = Reader.nextInt();
            int h = Reader.nextInt();
            if (w == 0 && h == 0) {
                break;
            }

            int[][] g = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    g[i][j] = Reader.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (g[i][j] == 0 || visited[i][j]) {
                        continue;
                    }

                    // bfs
                    Queue<Pair> que = new LinkedList<>();
                    que.offer(new Pair(i, j));
                    visited[i][j] = true;
                    count++;

                    while (!que.isEmpty()) {
                        Pair pair = que.poll();

                        for (int k = 0; k < dy.length; k++) {
                            int y = pair.first + dy[k];
                            int x = pair.second + dx[k];

                            // range
                            if (y >= 0 && y < h && x >= 0 && x < w) {
                                if (g[y][x] == 1 && visited[y][x] == false) {
                                    visited[y][x] = true;
                                    que.offer(new Pair(y, x));
                                }
                            }
                        }
                    }
                }
            }
            answer.append(count).append('\n');
        }

        System.out.println(answer);
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
