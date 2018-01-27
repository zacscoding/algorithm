package chap08.dp.p11057;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author zacconding
 * @Date 2018-01-27
 * @GitHub : https://github.com/zacscoding
 */
public class Try1 {
    public static long[][] dp = new long[1001][10];
    public static final int mod = 10007;
    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int N = Reader.nextInt();
        for(int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=0; k<=j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
                }
            }
        }

        long answer = 0L;
        for(int i=0; i<=9; i++) {
            answer = (answer +  dp[N][i]) % mod;
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
