package chap08.dp.p1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Try {
    // dp[i] : i를 1로 만드는데 필요한 최소 연산 수
    private static int[] dp = new int[1000001];
    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        System.out.println(solve(n));
    }
    
    // Top-buttom
    public static int solve(int n) {
        // 기저
        if(n == 1) {
            return 0;
        }
        // dp
        if(dp[n] != 0) {
            return dp[n];
        }
        
        int prev = solve(n-1);
        if(n % 2 == 0) {
            prev = Math.min(prev, solve(n/2));
        }
        if(n%3 == 0) {
            prev = Math.min(prev, solve(n/3));
        }
        return dp[n] = prev + 1;
    }
    

    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        public static void init(InputStream input){
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public static String nextLine() throws IOException{
            return reader.readLine();
        }

        public static String next() throws IOException{
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public static int nextInt() throws IOException{
            return Integer.parseInt(next());
        }

        public static void close() throws IOException{
            if (reader != null)
                reader.close();
        }
    }
}
