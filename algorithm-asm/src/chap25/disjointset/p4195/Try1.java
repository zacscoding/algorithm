package chap25.disjointset.p4195;
/*

https://www.acmicpc.net/problem/4195

 */

import java.io.*;
import java.util.*;

public class Try1 {	
	public static int count;
	public static Map<String,Integer> network;
	public static int[] parent;
	public static int[] rank;
	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		int cases = Reader.nextInt();
		
		while(cases-- > 0) {
			count = Reader.nextInt();
			
			network.clear();
			parent = new int[count+1];
			rank = new int[count+1];
			int idx = 0;
			for(int i=0; i<count; i++) {
				String f1 = Reader.next();
				String f2 = Reader.next();
				System.out.println(f1 + " : "+f1.hashCode());
				System.out.println(f2 + " : "+f2.hashCode());
				
//				Integer p1 = network.get(f1);
//				Integer p2 = network.get(f2);
//				
//				if(p1 == null) { //f1 처음 가입					
//					p1 = idx++;
//					parent[p1] = p1;
//				} 
//				
//				if(p2 == null) { //f2 처음 가입
//					p2 = idx++;
//					parent[p2] = p2;
//				}
//				
//				union(p1,p2);				
//				System.out.println(rank[p1]);
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
