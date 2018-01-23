package chap08.dp.p11727;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] d = new int[1001];
    public static int MOD = 10007;

    public static void main(String[] args) throws Exception{
        Reader.init(System.in);
        int n = Reader.nextInt();
        int answer = solveByTopAndButtom(n);
        // int answer = solveByButtomAndTop(n);
        
        System.out.println(answer);
    }

    // top and buttom
    public static int solveByTopAndButtom(int n){
        if (d[n] != 0) {
            return d[n];
        }

        return d[n] = (solveByTopAndButtom(n - 1) + (2 * solveByTopAndButtom(n - 2))) % MOD;
    }
    
    
    // buttom and top
    public static int solveByButtomAndTop(int n) {
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + 2 * d[i - 2];
            d[i] %= 10007;
        }
        
        return d[n];
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

