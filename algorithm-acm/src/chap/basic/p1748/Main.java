package chap.basic.p1748;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1748
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String data = "11";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);
        int N = Reader.nextInt();
        int n = count(N);
        int sum = 0;

        if (n != 1) {
            sum += total(n - 1);
        }

        int start = (int) Math.pow(10, n - 1);
        int count = n * (N - start + 1);
        sum += count;
        System.out.println(sum);
    }

    static int count(int n) {
        int i = 0;
        while (n > 0) {
            i++;
            n /= 10;
        }
        return i;
    }

    // n 자리 수 전체 자리수의 합 e.g) n == 2 => 12345...100 의 자리수
    static int total(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int start = (int) Math.pow(10, i - 1);
            int last = (int) Math.pow(10, i) - 1;
            int count = i * (last - start + 1);
            sum += count;
        }

        return sum;
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
