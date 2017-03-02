package chap23.priorityquenheap.prob2;

import java.io.*;
import java.util.*;

/*

https://www.acmicpc.net/problem/1927
 
 */
public class Main {	
	static int N;	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		N = Reader.nextInt();
		PriorityQueue<Integer> que = new PriorityQueue<>(100000);
		
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
	}	
}
