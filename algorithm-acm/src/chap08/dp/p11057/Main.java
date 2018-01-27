package chap08.dp.p11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11057
 * 
 * @author zaccoding
 * @Date 2017. 9. 21.
 */
public class Main {
    // 길이가 i이고 마지막 숫자가 j인 오르막 수의 개수
    static long dp[][] = new long[10001][10];
    static final long mod = 10007L;
    public static void main(String[] args) throws IOException {
        // init
        Reader.init(System.in);
        int N = Reader.nextInt();
        
        // solve
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }
        
        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<=j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= mod;
                }
            }
        }
        
        // answer
        long answer = 0;
        for(int i=0; i<10; i++) {
            answer += dp[N][i];
        }
        
        System.out.println(answer % mod);
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
