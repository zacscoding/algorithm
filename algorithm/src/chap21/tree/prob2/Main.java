package chap21.tree.prob2;

import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> adj = new ArrayList<>(100000);	
	static int n;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);		
		n = Reader.nextInt();		
		parent = new int[n];		
		for(int i=0;i<n;i++) {
			parent[i] = -1;
		}
		
		for(int i=0;i<n-1;i++) {			
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			List<Integer> adj1 = adj.get(a-1);
			List<Integer> adj2 = adj.get(a-1);
			if(adj1 == null) {
				adj1 = new LinkedList<>();
				adj.set(a-1,adj1);
			}
			if(adj2 == null) {
				adj2 = new LinkedList<>();
				adj.set(b-1,adj2);
			}			
			adj1.add(b-1);
			adj2.add(a-1);			
		}
		dfs(0);
		
		for(int i=1;i<n;i++) {			
			System.out.println(parent[i]+1);
		}	
	}
	
	public static void dfs(int here) {
		List<Integer> adjList = adj.get(here);
		for(int i=0;i<adjList.size();i++) {
			if(parent[i] == -1) {
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
