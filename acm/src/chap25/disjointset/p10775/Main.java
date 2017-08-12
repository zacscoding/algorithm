package chap25.disjointset.p10775;

/*

https://www.acmicpc.net/problem/10775

 */

import java.io.*;
import java.util.*;


public class Main {
	public static int[] parent = new int[100001];
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		int G = Reader.nextInt();
		int P = Reader.nextInt();
		
		//init
		for(int i=0; i<=G; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		for(int i=0; i<P; i++) {
			int g = Reader.nextInt();
			int parent = find(g);
			if(parent > 0) {				
				union(parent,parent-1);
				count++;
			} else {
				break;
			}	
		}	
		
		
		System.out.println(count);
		
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
		if(u > v) {
			int temp = u;
			u = v;
			v = temp;
		}
		
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
		
		public static void close() throws IOException {
			if(reader != null)
				reader.close();
		}
		
	}
}
