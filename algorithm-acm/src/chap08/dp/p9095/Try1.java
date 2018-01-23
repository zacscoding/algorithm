package chap08.dp.p9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author zaccoding
 * github : https://github.com/zacscoding
 * @Date : 2018-01-22
 */
public class Try1 {
    public static int[] dp = new int[12];
    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int T = Reader.nextInt();
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        while(T -- > 0) {
            int n = Reader.nextInt();
            if(dp[n] != 0) {
                System.out.println(dp[n]);
                continue;
            }
            for(int i=4; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            System.out.println(dp[n]);
        }
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

        public static void close() throws IOException {
            if (reader != null)
                reader.close();
        }

    }
}
