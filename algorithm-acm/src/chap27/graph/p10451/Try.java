package chap27.graph.p10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10451
 * 
 * @author zaccoding
 * @Date 2017. 9. 19.
 */
public class Try {
    public static int[][] adj;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int T = Reader.nextInt();
        while(T-- > 0) {
            // init
            int N = Reader.nextInt();
            adj= new int[N+1][N+1];
            visited = new boolean[N+1];
            for(int i=1; i<=N; i++) {
                int v = Reader.nextInt();
                adj[i][v] = 1;
            }
            
            int cnt = 0;
            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    int last = dfs(i);
                    if(adj[last][i] ==1) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    
    public static int dfs(int here) {        
        visited[here] = true;
        int ret = here;
        
        for(int i=1; i<adj[here].length; i++) {
            if(adj[here][i] == 1 && !visited[i]) {
                ret = dfs(i);
            }
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
