package chap.basic.bruteforce.p14500;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/14500
 */
public class Main {

    static int N, M;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        String data = "4 10\n"
                      + "1 2 1 2 1 2 1 2 1 2\n"
                      + "2 1 2 1 2 1 2 1 2 1\n"
                      + "1 2 1 2 1 2 1 2 1 2\n"
                      + "2 1 2 1 2 1 2 1 2 1";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        N = Reader.nextInt();
        M = Reader.nextInt();
        a = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = Reader.nextInt();
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1
                if (j + 3 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i][j + 3];
                    if (max < t) {
                        max = t;
                    }
                }

                // 2
                if (i + 3 < N) {
                    int t = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 3][j];
                    if (max < t) {
                        max = t;
                    }
                }

                // 3
                if (i + 1 < N && j + 1 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i + 1][j] + a[i + 1][j + 1];
                    if (max < t) {
                        max = t;
                    }
                }

                // 4
                if (i + 2 < N && j + 1 < M) {
                    int t = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 2][j + 1];
                    if (max < t) {
                        max = t;
                    }
                }

                // 5
                if (i + 2 < N && j - 1 >= 0) {
                    int t = a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 2][j - 1];
                    if (max < t) {
                        max = t;
                    }

                }

                // 6, 7
                if (i + 2 < N && j + 1 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 2][j + 1];
                    if (max < t) {
                        max = t;
                    }

                    t = a[i][j] + a[i][j + 1] + a[i + 1][j] + a[i + 2][j];
                    if (max < t) {
                        max = t;
                    }
                }

                // 8
                if (i - 1 >= 0 && j + 2 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i - 1][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 9
                if (i + 1 < N && j + 2 < M) {
                    int t = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 1][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 10
                if (i + 1 < N && j + 2 < M) {
                    int t = a[i][j] + a[i + 1][j] + a[i][j + 1] + a[i][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 11
                if (i + 1 < N && j + 2 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 12
                if (i + 2 < N && j + 1 < M) {
                    int t = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 2][j + 1];
                    if (max < t) {
                        max = t;
                    }
                }

                // 13
                if (i + 1 < N && i - 1 >= 0 && j + 1 < M) {
                    int t = a[i][j] + a[i + 1][j] + a[i][j + 1] + a[i - 1][j + 1];
                    if (max < t) {
                        max = t;
                    }
                }

                // 14
                if (i - 1 >= 0 && j + 2 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i - 1][j + 1] + a[i - 1][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 15
                if (i + 1 < N && j + 2 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i + 1][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 16
                if (i + 1 < N && j + 2 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i + 1][j + 1] + a[i][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 17
                if (i - 1 >= 0 && j + 2 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i - 1][j + 1] + a[i][j + 2];
                    if (max < t) {
                        max = t;
                    }
                }

                // 18
                if (i - 1 >= 0 && i + 1 < N && j + 1 < M) {
                    int t = a[i][j] + a[i][j + 1] + a[i - 1][j + 1] + a[i + 1][j + 1];
                    if (max < t) {
                        max = t;
                    }
                }

                // 19
                if (i + 2 < N && j + 1 < M) {
                    int t = a[i][j] + a[i + 1][j] + a[i + 1][j + 1] + a[i + 2][j];
                    if (max < t) {
                        max = t;
                    }
                }
            }
        }

        System.out.println(max);
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
