package chap.basic.p10817;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr = new int[3];
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = Reader.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[1]);		
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
