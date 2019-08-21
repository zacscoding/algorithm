package chap.basic.bruteforce.p3085;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/3085
 */
public class Main1 {

    static int N;
    static char[][] a = new char[50][50];

    public static void main(String[] args) throws IOException {
//        String data = "5\n"
//                      + "YCPZY\n"
//                      + "CYZZP\n"
//                      + "CCPPP\n"
//                      + "YCYZC\n"
//                      + "CPPZZ";
//        InputStream stream = new ByteArrayInputStream(data.getBytes());
//        System.setIn(stream);
        Reader.init(System.in);

        N = Reader.nextInt();
        int max = -1;

        for (int i = 0; i < N; i++) {
            a[i] = Reader.nextLine().trim().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, maxRow(i));
            max = Math.max(max, maxCol(i));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // i,j 와 i, j+1 교환
                if (isRange(i, j + 1)) {
                    swap(i, j, i, j + 1);
                    int tempMax = Math.max(maxCol(j), maxCol(j + 1));
                    max = Math.max(max, tempMax);
                    swap(i, j + 1, i, j);
                }

                // i,j 와 i+1, j 교환
                if (isRange(i + 1, j)) {
                    swap(i, j, i + 1, j);
                    int tempMax = Math.max(maxRow(i), maxRow(i + 1));
                    max = Math.max(max, tempMax);
                    swap(i + 1, j, i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = tmp;
    }

    static boolean isRange(int row, int col) {
        return row < N && col < N;
    }

    static int maxRow(int row) {
        int max = -1;

        char ch = a[row][0];
        int count = 1;

        for (int j = 1; j < N; j++) {
            if (a[row][j] == ch) {
                count++;

                if (j == N - 1) {
                    max = Math.max(max, count);
                    break;
                }
            } else {
                max = Math.max(max, count);
                ch = a[row][j];
                count = 1;
            }
        }

        return max;
    }

    static int maxCol(int col) {
        int max = -1;

        char ch = a[0][col];
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (a[i][col] == ch) {
                count++;

                if (i == N - 1) {
                    max = Math.max(max, count);
                    break;
                }
            } else {
                max = Math.max(max, count);
                ch = a[i][col];
                count = 1;
            }
        }

        return max;
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
