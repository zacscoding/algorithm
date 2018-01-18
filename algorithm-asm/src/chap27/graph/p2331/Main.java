package chap27.graph.p2331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2331
 * 
 * @author zaccoding
 * @Date 2017. 9. 20.
 */
public class Main {
    // checked[i] = N == 숫자 i의 방문 순서 N번째 
    static int[] checked = new int[1000000];
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int A = Reader.nextInt();
        int P = Reader.nextInt();
        
        System.out.println(length(A,P,1));
    }
    
    public static int next(int a, int p) {
        int ans = 0;
        
        while(a > 0) {
            ans += Math.pow(a%10,p);
            a /= 10;
        }
        
        return ans;
    }
    
    public static int length(int a, int p, int cnt) {
        if(checked[a] != 0) {
            return checked[a] - 1;
        }
        // 방문 순서
        checked[a] = cnt;
        int b = next(a,p);
        return length(b, p, cnt+1);
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
