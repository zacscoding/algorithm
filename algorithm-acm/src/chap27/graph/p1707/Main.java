package chap27.graph.p1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1707
 * 
 * @author zaccoding
 * @Date 2017. 9. 13.
 */
public class Main {    
    public static ArrayList<Integer>[] adj;
    public static int[] color;
    public static int T;
    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);        
        T = Reader.nextInt();        
        while(T-- > 0) {        
            // init and make graph
            int n = Reader.nextInt();
            int v = Reader.nextInt();
            
            adj = (ArrayList<Integer>[])new ArrayList[n+1];
            color = new int[n+1];
            for(int i=1; i<adj.length; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for(int i=0; i<v; i++) {
                int v1 = Reader.nextInt();
                int v2 = Reader.nextInt();
                adj[v1].add(v2);
                adj[v2].add(v1);
            }
            
            // solve            
            for(int i=1; i<=n; i++) {
                if(color[i] == 0) {
                    dfs(i,1);
                }
            }
            
            boolean result = true;
            A : for(int i=1; i<=n; i++) {
                for(int end : adj[i]) {
                    if(color[i] == color[end]) {
                        result = false;
                        break A;
                    }
                }
            }
            if(result) 
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }        
    }
    
    public static void dfs(int x, int c) {
        color[x] = c;
        for(int there : adj[x]) {
            if(color[there] == 0) 
                dfs(there,3-c);
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
