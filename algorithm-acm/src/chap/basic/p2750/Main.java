package chap.basic.p2750;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		int N = Reader.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Reader.nextInt();
		}
		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) { 
			System.out.println(arr[i]);
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
