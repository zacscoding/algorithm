package chap27.graph.p2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2667
 *
 * @author zacconding
 * @Date 2018-11-22
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int N;
    static int[][] h = new int[25][25];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] count = new int[25 * 25];

    public static void main(String[] args) throws Exception {
        // Reader.init(new FileInputStream(new File("src/chap27/graph/p2667/sample.txt")));
        Reader.init(System.in);
        N = Integer.parseInt(Reader.nextLine().trim());
        count = new int[N * N];
        for (int i = 0; i < N; i++) {
            String line = Reader.nextLine().trim();
            for (int j = 0; j < N; j++) {
                h[i][j] = line.charAt(j) - '0';
            }
        }

        int start = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (h[i][j] == 1) {
                    check(i, j, start++);
                }
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                priorityQueue.offer(count[i]);
            } else {
                break;
            }
        }
        System.out.println(priorityQueue.size());
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    static void check(int i, int j, int color) {
        if (!isRange(i, j) || h[i][j] != 1) {
            return;
        }

        h[i][j] = color;
        count[color - 2]++;
        for (int k = 0; k < 4; k++) {
            check(i + dx[k], j + dy[k], color);
        }
    }

    static boolean isRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
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
