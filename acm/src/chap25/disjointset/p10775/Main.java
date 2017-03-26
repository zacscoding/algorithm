package chap25.disjointset.p10775;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] parent = new int[100001];
	public static int[] rank = new int[100001];
	public static int G;
	public static int P;
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		
		G = Reader.nextInt();	
		for(int i=0;i<=G;i++) {
			parent[i] = -1;
			rank[i] = 1;
		}
		
		P = Reader.nextInt();		
		int count = 0;
		
		for(int i=0; i<P; i++) {
			int g = Reader.nextInt();			
			if(find(g) >= 1) {
				union(g,g-1);
				count++;
			} else {
				System.out.println(count);
				break;
			}
		}
	}
	
	public static int find(int u) {
		if(parent[u] < 0)
			return u;
		return 0;
	}
	
	public static void union(int u,int v) {
		u = find(u);
		v = find(v);
		if(u == v)
			return;
		
		parent[u] += parent[v];
		parent[v] = u;
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
