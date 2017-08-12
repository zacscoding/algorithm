package chap23.priority.p11279;

import java.io.*;
import java.util.*;

/*

https://www.acmicpc.net/problem/11279
 
 */
public class Main {
	public static int N;	
	public static void main(String[] args) throws Exception {
		//Reader.init(new FileInputStream("intput.txt"));
		Reader.init(System.in);		
		N = Reader.nextInt();
		
		List<Integer> heap = new ArrayList<>(N);
		
		for(int i=0;i<N;i++) {
			int val = Reader.nextInt();
			if(val == 0) {
				System.out.println(pop_heap(heap));
			} else {
				push_heap(heap,val);
			}
		}		
	}
	
	public static void push_heap(List<Integer> heap, int newValue) {
		heap.add(newValue);			
		int idx = heap.size() -1;			
		while( (idx > 0) && (heap.get((idx-1)/2) < heap.get(idx)) ) {
				swap(heap,idx,(idx-1)/2);
				idx = (idx -1) / 2;
		}
	}
		
	public static int pop_heap(List<Integer> heap) {
		if(heap.isEmpty())
			return 0;
		
		int ret = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int here = 0;
		while (true) {
			int left = here * 2 + 1, right = here * 2 + 2;
			if (left >= heap.size()) break;
			int next = here;
			
			if (heap.get(next) < heap.get(left))
				next = left;
			if (right < heap.size() && heap.get(next) < heap.get(right))
				next = right;
			if (next == here)
				break;
			swap(heap, here, next);
			here = next;
		}
		return ret;
	}
		
	public static void swap(List<Integer> heap,int idx1,int idx2) {
		int idx1Val = heap.get(idx1);
		heap.set(idx1, heap.get(idx2));
		heap.set(idx2, idx1Val);		
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
