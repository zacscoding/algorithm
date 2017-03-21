package chap23.priority.p2014;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/2014
 */
public class Main {
	static int K;
	static int N;
	static long[] prime;
	static PriorityQueue<Long> heap;
	static TreeMap<Long,Integer> map;
	static Integer defaultInt = Integer.valueOf(1);

	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		K = Reader.nextInt();
		N = Reader.nextInt();
		prime = new long[K];
		heap = new PriorityQueue<Long>();
		map = new TreeMap<>();
		
		solve();
		
		System.out.println(heap.poll());
	}
	
	public static void solve() throws Exception {
		for(int i=0;i<K;i++) {				
			prime[i] = Reader.nextLong();	
			if(map.get(prime[i]) == null) {
				heap.add(prime[i]);
				map.put(prime[i],defaultInt);
				if(heap.size() > N) 
					heap.poll();
			}									
			for(int j=0;j<=i;j++) {
				long value = prime[i] * prime[j];
				if(map.get(value) == null) {
					heap.add(value);
					map.put(value, defaultInt);
					if(heap.size() > N)
						heap.poll();
				}								
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
		
		public static long nextLong() throws Exception {
			return Long.parseLong( next() );
		}
	}	
}
