package chap23.priority.p2075;

import java.io.*;
import java.util.*;

class Pair {
	int idx;
	long value;
	
	public Pair(int idx,long value) {
		this.idx = idx;
		this.value = value;
	}
}

public class Try1 {
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		int N = Reader.nextInt();		
		Stack<Long>[] stack = new Stack[N];
		PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return (int)(o2.value - o1.value);
			}			
		});
				
		for(int i=0;i<N;i++) {
			stack[i] = new Stack<Long>();
		}		
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<N;j++) {
				stack[j].push(Reader.nextLong());
			}
		}		
		for(int i=0;i<N;i++) {
			Pair pair = new Pair(i,Reader.nextLong());
			heap.offer(pair);
		}
		
		for(int i=1;i<N;i++) {
			Pair pair = heap.poll();
			pair.value = stack[pair.idx].pop();
			heap.add(pair);
		}
		System.out.println(heap.peek().value);
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
