package chap23.priority.p11279;

import java.io.*;
import java.util.*;


public class Main2 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		N = Reader.nextInt();		
		/*PriorityQueue<Integer> que = new PriorityQueue<Integer>(N, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}			
		});*/
		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(N,Collections.reverseOrder());
		
		for(int i=0;i<N;i++) {
			int val = Reader.nextInt();
			if(val == 0) {
				int res = que.isEmpty() ? 0 : que.poll();
				System.out.println(res);
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
