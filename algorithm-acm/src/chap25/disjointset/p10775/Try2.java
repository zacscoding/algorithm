package chap25.disjointset.p10775;

import java.io.*;
import java.util.*;

public class Try2 {	
	public static int G,P;
	public static int[] parent = new int[100001];
	public static int[] rank = new int[100001];
	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);		
		G = Reader.nextInt();
		P = Reader.nextInt();
				
		for(int i=0;i<=G;i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		int count = 1;		
		union(0,Reader.nextInt());
				
		A: for(int i=1; i<P;i++) {
			int g = Reader.nextInt();
			if(find(g) > 0) {
				union(g,0);
				count++;
			} else {
				for(int j=g-1; j>=0; j--) {
					if(j==0) {
						break A;
					}
					
					if(find(j) > 0) {
						union(j,0);
						count++;
					}
				}
			}			
		}	
		
		System.out.println(count);
	}
	
	public static int find(int u) {
		if(u == parent[u]) 
			return u;
		return parent[u] = find(parent[u]);
	}
	
	// u가 속한 트리와 v가 속한 트리를 합친다.
	public static void union(int u,int v) {
		u = find(u);
		v = find(v);		
		// u와 v가 이미 같은 집합에 속하는 경우를 걸러낸다.
		if(u == v)
			return;
		if(rank[u] > rank[v] ) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		// rank[v]가 항상 rank[u] 이상이므로 u를 v의 자식으로 넣는다.
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
		
		public static void close() throws IOException {
			if(reader != null)
				reader.close();
		}
		
	}
}
