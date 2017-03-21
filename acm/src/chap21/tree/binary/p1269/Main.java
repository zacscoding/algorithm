package chap21.tree.binary.p1269;

import java.io.*;
import java.util.*;

/*

https://www.acmicpc.net/problem/1269

 */

public class Main {	 
	public static void main(String[] args) throws Exception {
		
		Reader.init(System.in);		
		int n = Reader.nextInt(),m=Reader.nextInt();
		int common = 0;
		
		TreeSet<Integer> set = new TreeSet<>();		
		for(int i=0;i<n;i++) {
			set.add(Reader.nextInt());
		}
		
		for(int i=0;i<m;i++) {
			if(set.contains(Reader.nextInt()))
				common++;
		}		
		System.out.println(n+m-(2*common));		
	}

	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		
		public static void init(InputStream input) throws IOException {
			reader = new BufferedReader(new InputStreamReader(input));			
		}
		
		public static String nextLine() throws IOException {
			return reader.readLine();
		}
		
		public static String next() throws IOException {
			while(tokenizer==null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}		
	}
}
