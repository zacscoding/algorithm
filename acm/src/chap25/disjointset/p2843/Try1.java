package chap25.disjointset.p2843;

/*

https://www.acmicpc.net/problem/2843

로직1)
adj[i] = j : i에서 j로 간선 존재(i == j 으면 루프)
dest[i] = j : i에서 출발에서 j로 도착
(union 시 항상 도착지를 root로 유지)



 */

import java.io.*;
import java.util.*;



public class Try1 {	
	public static int N;
	public static int[] parent;
	public static int[] adj;
	
	public static int Q;
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		N = Reader.nextInt();
		parent = new int[N+1];
		adj = new int[N+1];
		
		for(int i=1; i<=N; i++) {			
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {			
			adj[i] = Reader.nextInt();
			union(i,adj[i]);
		}
		
		//sol
		int Q = Reader.nextInt();
		for(int i=0; i<Q; i++) {
			int comm = Reader.nextInt();
			int idx = Reader.nextInt();
			if(comm == 1) {
				if(idx == adj[idx]) {
					System.out.println(idx);
				} else {
					if(parent[adj[idx]] == parent[idx]) {
						if(parent[idx] == adj[parent[idx]]);
					}
				}				
			} else {
				adj[idx] = idx;
				parent[idx] = idx;
			}
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
		find(u);
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
