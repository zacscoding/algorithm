package chap25.disjointset.p1976;

/*

https://www.acmicpc.net/problem/1976

 */

import java.io.*;
import java.util.*;

public class Main {	
	public static int[] parent = new int[201];
	public static int[] rank = new int[201];
	public static int n,m;
	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		
		n = Reader.nextInt();
		m = Reader.nextInt();
		for(int i=0;i<=n;i++) {
			parent[i] = i;
			rank[i] = 1;
		}		
		for(int i=0; i<m; i++) {
			int adj = Reader.nextInt();
			int u = Reader.nextInt();
			int v = Reader.nextInt();
			if(adj == 1) {
				union(u,v);				
			}
		}
		
		int parent = find(Reader.nextInt());
		boolean isPossible = false;		
		for(int i=1;i<=m;i++) {
			if(i == m) {
				isPossible = true;
				break;
			}
			
			if(parent != find(Reader.nextInt())) {
				break;
			}
		}		
		
		if(isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
			
		
	}
	
	
	public static int find(int u) {
		if(u == parent[u])
			return u;
		return parent[u] = find(parent[u]);
	}
	
	public static void union(int u,int v) {
		u = find(u);
		v = find(v);
		
		if(u == v)
			return;
		
		if(rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		if(rank[u] == rank[v])
			rank[v]++;
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

