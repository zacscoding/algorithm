package chap27.graph.p4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4963
 *
 * @author zacconding
 * @Date 2018-11-22
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int w;
    static int h;
    static int[][] a = new int[50][50];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        while (true) {
            w = Reader.nextInt();
            h = Reader.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    a[i][j] = Reader.nextInt();
                }
            }

            int start = 2;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 1) {
                        check(i, j, start++);
                    }
                }
            }

            System.out.println(start - 2);
            //display();
        }
    }

    static void check(int i, int j, int cnt) {
        if (!isRange(i, j) || a[i][j] != 1) {
            return;
        }

        a[i][j] = cnt;
        for (int k = 0; k < dy.length; k++) {
            check(i + dy[k], j + dx[k], cnt);
        }
    }

    static boolean isRange(int i, int j) {
        return i >= 0 && j >= 0 && i < h && j < w;
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
