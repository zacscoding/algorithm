package chap08.dp.p10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author zaccoding
 * github : https://github.com/zacscoding
 * @Date : 2018-01-25
 */
public class Try1 {
    public static long[][] dp = new long[101][10];
    public static long mod = 1000000000;
    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int N = Reader.nextInt();
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1L;
        }
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                dp[i][j] = 0;
                if(j-1>= 0) dp[i][j] += dp[i-1][j-1];
                if(j+1<=9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= mod;
            }
        }
        long answer = 0L;
        for(int i=0; i<=9; i++) {
            answer = (answer + dp[N][i]) % mod;
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
