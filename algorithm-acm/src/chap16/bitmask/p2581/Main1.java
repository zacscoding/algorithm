package chap16.bitmask.p2581;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2581
 * eratosthenes
 */
public class Main1 {

    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int M = Reader.nextInt();
        int N = Reader.nextInt();
        dp = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = true;
        }

        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            if (dp[i] == true) {
                for (int j = i * i; j <= N; j += i) {
                    dp[j] = false;
                }
            }
        }

        int sum = 0;
        int minPrime = -1;
        boolean findFirst = false;

        for (int i = M; i <= N; i++) {
            if (dp[i]) {
                sum += i;
                if (findFirst == false) {
                    minPrime = i;
                    findFirst = true;
                }
            }
        }

        if (sum != 0) {
            System.out.println(sum);
        }
        System.out.println(minPrime);
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
