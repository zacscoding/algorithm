package chap21.tree.p11725;

import java.io.*;
import java.util.*;

public class Try2 {
	static int[][] adj;
	static int[] parent;
	static int n;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);		
		n = Reader.nextInt();		
		adj = new int[n][];
		parent = new int[n];
		
		for(int i=0;i<n;i++) {
			adj[i] = new int[n];
			parent[i] = -1;
		}
		
		for(int i=0;i<n-1;i++) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			adj[a-1][b-1] = 1;
			adj[b-1][a-1] = 1;			
		}
		dfs(0);
		
		for(int i=1;i<n;i++) {			
			System.out.println(parent[i]+1);
		}	
	}
	
	public static void dfs(int here) {
		for(int there=0; there<adj[here].length;there++) {
			if(adj[here][there]==1 && parent[there] == -1) {
				parent[there] = here;
				dfs(there);
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
