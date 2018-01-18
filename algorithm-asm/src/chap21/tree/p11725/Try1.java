package chap21.tree.p11725;

import java.io.*;
import java.util.*;


public class Try1 {
	static int[][] adj;
	static boolean[] visited;
	static int[] parent;
	static int n;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);		
		n = Reader.nextInt();		
		adj = new int[n][];
		visited = new boolean[n];
		parent = new int[n];
		
		for(int i=0;i<n;i++) {
			adj[i] = new int[n];
		}
		
		for(int i=0;i<n-1;i++) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			adj[a-1][b-1] = 1;
			adj[b-1][a-1] = 1;			
		}		
		dfsAll();
		for(int i=1;i<n;i++) {			
			System.out.println(parent[i]+1);
		}	
	}
	
	public static void dfsAll() {
		for(int i=0;i<n;i++) {
			if(!visited[i])
				dfs(i);
		}
		
	}
	
	public static void dfs(int here) {
		visited[here] = true;		
		for(int i=0;i<adj[here].length;i++) {
			if(adj[here][i]==1 && !visited[i]) {
				parent[i] = here;
				dfs(i);
			}
		}
	}	
	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		
		public static void init(InputStream input) throws Exception {
			reader = new BufferedReader(new InputStreamReader(input));
		}
		
		public static String next() throws Exception {
			while(tokenizer == null || !tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(reader.readLine());
			return tokenizer.nextToken();
		}
		
		public static String readLine() throws Exception{
			return reader.readLine();
		}
		
		public static int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		
	}
	
}
