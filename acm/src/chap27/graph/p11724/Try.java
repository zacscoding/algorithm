package chap27.graph.p11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11724
 * 
 * @author zaccoding
 * @Date 2017. 9. 13.
 */
public class Try {
    private static int N,M;
    private static boolean[] visited;
    private static List<Integer>[] adj;
    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        N = Reader.nextInt();
        M = Reader.nextInt();
        
        visited = new boolean[N+1];
        adj = (ArrayList<Integer>[]) new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<Integer>(N);
        }
        
        for(int i=0; i<M; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();            
            adj[v1].add(v2);
            adj[v2].add(v1);            
        }
        
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i])  answer++;
            dfs(i);            
        }
        System.out.println(answer);
    }
    
    public static void dfs(int x) {
        if(visited[x]) return;        
        visited[x] = true;
        for(int i=0; i<adj[x].size(); i++) {
            int there = adj[x].get(i);
            if(!visited[there]) {
                dfs(there);
            }
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
