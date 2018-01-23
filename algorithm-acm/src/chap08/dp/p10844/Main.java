package chap08.dp.p10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10844
 * 64
 * 
 * @author zaccoding
 * @Date 2017. 9. 20.
 */
public class Main {    
    // dp[i][j] == 길이 i 인 경우, j의 개수
    static long[][] dp = new long[101][10];
    static final int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int N = Reader.nextInt();
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1L;
        }
        
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                dp[i][j] = 0;
                if(j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                if(j+1 <= 9) dp[i][j] += dp[i-1][j+1];                
                dp[i][j] %= mod; 
            }
        }
        
        long answer = 0;
        for(int i=0; i<=9; i++) {
            answer += dp[N][i];
        }
         
        System.out.println(answer%mod);
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
