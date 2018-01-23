package chap08.dp.p11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author zaccoding
 * github : https://github.com/zacscoding
 * @Date : 2018-01-23
 */
public class Try2 {
    public static int[] dp = new int[10001];
    public static int[] p = new int [10001];
    public static int N;
    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        N = Reader.nextInt();
        for(int i=1; i<=N; i++) {
            p[i] = Reader.nextInt();
        }
        dp[1] = p[1];
        // buttom - top
        for(int i=2; i<=N; i++) {
            int temp = p[i];
            for(int j=1; j<i; j++) {
                temp = Math.max(temp, dp[j] + p[i-j]);
            }
            dp[i] = temp;
        }
        System.out.println(dp[N]);
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
            while(tokenizer ==null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }
    }
}
