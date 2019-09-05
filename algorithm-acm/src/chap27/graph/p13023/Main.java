package chap27.graph.p13023;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/13023
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String data = "8 8\n"
                      + "1 7\n"
                      + "3 7\n"
                      + "4 7\n"
                      + "3 4\n"
                      + "4 6\n"
                      + "3 5\n"
                      + "0 4\n"
                      + "2 7";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);
        int N = Reader.nextInt();
        int M = Reader.nextInt();

        ArrayList<Integer>[] g = new ArrayList[N];
        ArrayList<Edge> edges = new ArrayList<>(M * 2);
        boolean[][] connected = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();

            g[v1].add(v2);
            g[v2].add(v1);

            connected[v1][v2] = true;
            connected[v2][v1] = true;

            edges.add(new Edge(v1, v2));
            edges.add(new Edge(v2, v1));
        }

        int size = edges.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }

                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }

                if (!connected[B][C]) {
                    continue;
                }

                for (Integer E : g[D]) {
                    if (E != A && E != B && E != C) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    static class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
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
