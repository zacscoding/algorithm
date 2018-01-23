package chap08.dp.p11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Try {
    private static int[] dp = new int[1001];
    private static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        int n = Reader.nextInt();
        System.out.println(solve(n));
        Reader.close();
    }
    
    public static int solve(int n) {
        if(dp[n] != 0) return dp[n];
        return dp[n] = (solve(n-1) + solve(n-2))%MOD;        
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
