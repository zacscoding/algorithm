package chap08.dp.p11054;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11054
 *
 * @author zacconding
 * @Date 2018-02-11
 * @GitHub : https://github.com/zacscoding
 */
public class Main2 {

    public static int[] d = new int[1001];
    public static int[] rd = new int[1001];
    public static int n;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        n = Reader.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Reader.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            rd[n - i + 1] = 1;
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i] && (d[i] < d[j] + 1)) {
                    d[i] = d[j] + 1;
                }
            }

            for (int j = n; j > (n - i + 1); j--) {
                if (a[j] < a[n - i + 1] && (rd[n - i + 1] < rd[j] + 1)) {
                    rd[n - i + 1] = rd[j] + 1;
                }
            }
        }

        int answer = d[1] + rd[1] - 1;
        for (int i = 2; i <= n; i++) {
            if (answer < d[i] + rd[i] - 1) {
                answer = d[i] + rd[i] - 1;
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
