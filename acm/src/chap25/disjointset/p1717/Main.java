package chap25.disjointset.p1717;

/*

https://www.acmicpc.net/problem/1717

 */

import java.io.*;
import java.util.*;

public class Main {	
	public static int n;
	public static int m;
	public static int[] parent = new int[1000001];
	public static int[] rank = new int[1000001];
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		
		n = Reader.nextInt();
		m = Reader.nextInt();
				
		for(int i=0; i<=n;i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		for(int i=0;i<m;i++) {
			int comm = Reader.nextInt();
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			
			if(comm == 0) { //합치기
				union(a,b);
			} else { //같은지 다른지
				if(find(a) == find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
				
			}
		}
	}
	
	//부모찾기 + 부모 하나로 갱신
	public static int find(int u) {
		if(u == parent[u])
			return parent[u];
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
