package chap08.dp.p11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11052
 *
 * @author zaccoding
 * github : https://github.com/zacscoding
 * @Date : 2018-01-23
 */
public class Main {
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int N = Reader.nextInt();
        int[] p = new int [N+1];
        for(int i=1; i<=N; i++) {
            p[i] = Reader.nextInt();
            dp[i] = p[i];
            for(int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i],p[j] + dp[i-j]);
            }
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
