package chap25.disjointset.p10775;
/*
https://www.acmicpc.net/problem/10775
 */


import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		int G = Reader.nextInt();
		int P = Reader.nextInt();		
		int[] g = new int[P+1];		
		boolean[] comp = new boolean[G+1];
		boolean isPossible = true;
		int count = 0;
		for(int i=0; i<P; i++) {
			if(isPossible) {
				g[i] = Reader.nextInt();
				for(int j=i; j>=0; j--) {
					if(j == 0) {
						isPossible=false;
						break;
					}
					
					if(comp[j]) {
						comp[j] = true;
						count++;
						break;
					}					
				}	
				
			} else {
				Reader.nextInt();
			}			
		}		
		System.out.println(count);
		
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
