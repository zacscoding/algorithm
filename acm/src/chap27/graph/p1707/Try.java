package chap27.graph.p1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1707
 * 
 * @author zaccoding
 * @Date 2017. 9. 13.
 */
public class Try {    
    
    public static void main(String[] args) {
        
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
