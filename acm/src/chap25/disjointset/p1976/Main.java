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
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int val = Reader.nextInt();
				if(j > i && val == 1)
					union(i,j);	
			}
		}
		
		
		boolean isPossible = true;		
		int prev = Reader.nextInt();
		
		for(int i=0;i<m-1;i++) {
			int cur = Reader.nextInt();			
			if(find(prev) != find(cur)) {
				isPossible = false;
				break;
			}
			prev = cur;
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

