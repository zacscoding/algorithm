package chap27.graph.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1260
 * 
 * @author zaccoding
 * @Date 2017. 9. 12.
 */
public class Main {
    public static int[][] adj;
    public static boolean[] visited;
    public static boolean[] visited2;
    public static Queue<Integer> que;
            
    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int N = Reader.nextInt();
        int M = Reader.nextInt();
        int V = Reader.nextInt();        
        adj = new int[N][N];
        visited = new boolean[N];
        visited2 = new boolean[N];
        que = new LinkedList<>();
        
        for(int i=0; i<M; i++) {
            int n = Reader.nextInt() - 1;
            int m = Reader.nextInt() - 1;
            adj[n][m] = adj[m][n] = 1;
        }           
        
        // dfs
        dfs(V-1);
        while(!que.isEmpty()) {
            System.out.print((que.poll() + 1) + " ");
        }
        System.out.println();
        bfs(V-1);
    }
    
    public static void bfs(int x) {
        que.offer(x);
        visited2[x] = true;
        System.out.print((x + 1) + " ");
        
        while(!que.isEmpty()) {
            int poll = que.poll();
            for(int i=0; i<adj[poll].length; i++) {
                if(adj[poll][i] == 1 && !visited2[i]) {
                    visited2[i] = true;
                    que.offer(i);
                    System.out.print((i + 1) + " ");
                }
            }            
        }
    }
    
    public static void dfs(int x) {
        visited[x] = true;
        que.offer(x);
        
        for(int i=0; i<adj[x].length; i++) {
            if(adj[x][i] ==1 && !visited[i]) {
                dfs(i);
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
