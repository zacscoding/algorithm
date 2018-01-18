package chap27.graph.p10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] adj;
    public static boolean[] c;
    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int T = Reader.nextInt();
        while(T-- > 0) {
            int N = Reader.nextInt();
            adj = new int[N+1];
            c = new boolean[N+1];
            
            for(int i=1; i<=N; i++) {
                adj[i] = Reader.nextInt();
            }
            
            
            int ans = 0;
            for(int i=1; i<=N; i++) {
                if(!c[i]) {
                    dfs(i);
                    ans ++;
                }
            }
            System.out.println(ans);
        }        
    }
    
    public static void dfs(int x) {
        if(c[x]) return;
        c[x] = true;
        dfs(adj[x]);
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
