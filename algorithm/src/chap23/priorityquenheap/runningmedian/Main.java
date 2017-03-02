package chap23.priorityquenheap.runningmedian;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		List<Integer> heap = new ArrayList<>();
		
		int n = Reader.nextInt();
		for(int i=0;i<n;i++) {
			push_heap(heap,Reader.nextInt());
			int median = heap.size() / 2;
			System.out.println(heap.get(median));
		}		
	}
	
	
	public static void push_heap(List<Integer> heap, int newValue) {
		heap.add(newValue);		
		int idx = heap.size() -1;		
		while( (idx > 0) && (heap.get((idx-1)/2) < heap.get(idx)) ) {
				int pIdx = (idx-1)/2;
				if(heap.get(pIdx) < heap.get(idx)) break;
			
				int idxVal = heap.get(idx);
				heap.set(idx, heap.get(pIdx));
				heap.set(pIdx,idxVal);
				idx = (idx -1) / 2;
		}
	}
	
	
	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		static void init(InputStream input) throws Exception {
			reader = new BufferedReader(new InputStreamReader(input));
		}
		
		static String next() throws Exception {
			while(tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static String nextLine() throws Exception {
			return reader.readLine();
		}
		
		static int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		
	}
}
