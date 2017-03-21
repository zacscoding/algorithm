package chap23.priority.p2075;

import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);		
		int n = Reader.nextInt();
		PriorityQueue<Long> heap = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			heap.offer(Reader.nextLong());
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<n;j++) {
				heap.offer(Reader.nextLong());
				heap.poll();
			}
		}				
		System.out.println(heap.peek());
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
			while(tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();			
		}
		
		public static int nextInt() throws IOException {
			return Integer.parseInt( next() );
		}
		
		public static long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
	
}
