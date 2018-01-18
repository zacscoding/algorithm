package chap27.graph.p2331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2331
 * 
 * @author zaccoding
 * @Date 2017. 9. 19.
 */
public class TryByDP {    
    public static int P;
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        
        int prev = Reader.nextInt();
        P = Reader.nextInt();
        Map<Integer,Integer> map = new HashMap<>(11000,0.999999f);
        int answer = 1;
        int idx = 1;
        map.put(prev, idx++);
        while(true) {
            int next = next(prev);
            Integer existIdx = map.get(next);
            if(existIdx != null) {
                answer = existIdx -1;
                break;
            }            
            prev = next;
            map.put(next, idx++);
        }
        
        System.out.println(answer);
    }
    
    public static int next(int prev) {
        String value = String.valueOf(prev);
        int ret = 0;
        
        for(int i=0; i<value.length(); i++) {
            char ch = value.charAt(i);
            ret += (Math.pow(ch-'0', P));
        }
        
        return ret;
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
