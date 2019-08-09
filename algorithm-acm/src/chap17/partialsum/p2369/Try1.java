package chap17.partialsum.p2369;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2369
 */
public class Try1 {

    static int[][] a;
    static int[][] psum;

    public static void main(String[] args) throws IOException {
        String data = "3 4 6\n"
                      + "1 1 1 1\n"
                      + "1 1 1 1\n"
                      + "1 1 1 1";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        int N = Reader.nextInt();
        int M = Reader.nextInt();
        int K = Reader.nextInt();
        psum = new int[N + 1][M + 1];
        a = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int r = Reader.nextInt();
                a[i][j] = r;
                psum[i][j] = r;
                psum[i][j] += psum[i - 1][j];
                psum[i][j] += psum[i][j - 1];
                psum[i][j] -= psum[i - 1][j - 1];
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // i x j 인 부분행렬
                for (int k = 1; k <= N - i; k++) {
                    for (int l = 1; l <= M - j; l++) {
                        int p = gridSum(k, l, k - i, l - j);
                        if (p % K == 0) {
                            result++;
                        }
                    }
                }
            }
        }

//        for (int k = i; k <= N - i + 1; k++) {
//            for (int l = j; l <= M; l++) {
//                int p = gridSum(k, l, k - i, l - j);
//                if (p % K == 0) {
//                    result++;
//                }
//            }
//        }
        System.out.println(result);
    }

    static int gridSum(int y1, int x1, int y2, int x2) {
        int ret = psum[y1][x1];

        if (y1 > 0) { ret -= psum[y1 - 1][x2]; }
        if (x1 > 0) { ret -= psum[y2][x1 - 1]; }
        if (y1 > 0 && x1 > 0) { ret += psum[y1 - 1][x1 - 1]; }

        return ret;
    }

    static void displayArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
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
