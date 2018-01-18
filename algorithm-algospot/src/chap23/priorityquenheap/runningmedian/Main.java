package chap23.priorityquenheap.runningmedian;

import java.io.*;
import java.util.*;

/*
 
 https://algospot.com/judge/problem/read/RUNNINGMEDIAN
 
 */


class RNG {
	static final int MOD = 20090711;
	int seed,a,b;
	RNG(int a,int b) {
		this.a = a;
		this.b = b;
		seed = 1983;
	}	
	public int next() {
		int ret = seed;
		seed = (int) ( ((seed* (long)a)+b)%MOD);
		return ret;
	}	
}



public class Main {	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		int cases = Reader.nextInt();
		while(cases-- > 0) {
			int n = Reader.nextInt();
			RNG rng = new RNG(Reader.nextInt(),Reader.nextInt());
			System.out.println(runningMedian(n,rng));
		}
	}
	
	public static int runningMedian(int n,RNG rng) {
		int ret = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int cnt=1; cnt<=n; cnt++) {
			if(maxHeap.size() == minHeap.size()) {
				maxHeap.add(rng.next());
			} else {
				minHeap.add(rng.next());
			}			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() 
					&& maxHeap.peek() > minHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(minHeap.poll());
			}
			ret = (ret + maxHeap.peek()) % RNG.MOD;
		}
		return ret;
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
