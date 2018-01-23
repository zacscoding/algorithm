package chap23.priority.p11286;

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static PriorityQueue<Integer> que; 
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		que = new PriorityQueue<Integer>(100000, new Comparator<Integer>() {
			@Override
			public int compare(Integer val1, Integer val2) {
				int comp = Math.abs(val1) - Math.abs(val2);
				if(comp == 0) {
					if(val1 < 0)
						return -1;
					else 
						return 1;
				}
				return comp;					
			}			
		});		
		N = Reader.nextInt();
		
		for(int i=0;i<N;i++) {
			int val = Reader.nextInt();
			if(val == 0) {
				if(que.isEmpty())
					System.out.println(0);
				else
					System.out.println(que.poll());
			} else {
				que.offer(val);
			}
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
		
		public static void close() throws IOException {
			if(reader != null)
				reader.close();
		}
		
	}
}
