package chap23.priority.p2696;

import java.io.*;
import java.util.*;

/*

https://www.acmicpc.net/problem/2696
 
 */


/*
5
1 2 3 4 5
5
9 8 7 6 5
12
23 23 22 22 13 3 5 5 3 -3
-7 -3
 */

public class Main {
	
	static int T;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		T = Reader.nextInt();
		while(T-- > 0) {
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			int M = Reader.nextInt();
			List<Integer> list = new LinkedList<>();
			
			for(int i=1;i<=M;i++) {
				int val = Reader.nextInt();
				
				if(maxHeap.size() == minHeap.size()) {
					maxHeap.offer(val);
				} else {
					minHeap.offer(val);
				}
				
				if(!maxHeap.isEmpty() && !minHeap.isEmpty() &&maxHeap.peek() > minHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(minHeap.poll());					
				}
				if(i%2!=0) {
					list.add(maxHeap.peek());
				}
			}			
			System.out.println(list.size());
			System.out.print(list.get(0) + " ");
			for(int i=1;i<list.size();i++) {
				if(i%10 == 0)
					System.out.println();
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			
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
