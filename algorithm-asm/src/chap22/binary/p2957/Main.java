package chap22.binary.p2957;

import java.io.*;
import java.util.*;

/*

https://www.acmicpc.net/problem/2957
 
 */
public class Main {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		TreeMap<Integer,Integer> map = new TreeMap<>();
		N = Reader.nextInt();
		
		map.put(0, 0);
		map.put(N+1, 0);
		
		long count = 0;
		for(int i=0;i<N;i++) {
			int val = Reader.nextInt();
			int m = 0;
			Integer higher = map.higherKey(val);
			Integer lower = map.lowerKey(val);
			
			m = Math.max(map.get(higher),map.get(lower));
			
			map.put(val, m+1);
			count+=m;
			System.out.println(count);
			
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
