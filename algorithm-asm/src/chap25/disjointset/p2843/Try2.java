package chap25.disjointset.p2843;

/*
https://www.acmicpc.net/problem/2843
 */

import java.io.*;
import java.util.*;

public class Try2 {
	public static int N;
	public static int[] adj;
	public static int[] visited;
	public static int[] cache;
	public static int checked = 0;
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		
		N = Reader.nextInt();
		adj = new int[N+1];
		cache = new int[N+1];
		visited = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			adj[i] = Reader.nextInt();
		}
		
		int Q = Reader.nextInt();
		
		for(int i=0; i<Q; i++) {
			int comm = Reader.nextInt();
			int idx = Reader.nextInt();
			
			if(comm == 1) {
				checked++;
				int dest = find(idx);
				if(dest == -1) {
					System.out.println("CIKLUS");
				} else {
					System.out.println(dest);
				}
			} else {
				adj[idx] = -1;
			}
		}
	}
	
	//check cycle(-1)
	//아니면 dest 반환
	public static int find(int u) {
		//cycle
		if(visited[u] == checked) {
			return -1;
		}	
		
		visited[u] = checked;
		
		//기저 간선이 없는 경우
		if(adj[u] == -1)
			return u;
		
		int dest = find(adj[u]);
		if(dest == -1) {
			return -1;			
		} else {
			return dest;
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
