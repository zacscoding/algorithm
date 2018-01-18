package chap22.binary.p1351;

import java.io.*;
import java.util.*;

/*

https://www.acmicpc.net/problem/1351

 */
public class Main {
	public static Map<Long,Long> map;
	public static int P;
	public static int Q;
	
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		Reader.init(System.in);
		long N = Reader.nextLong();
		P = Reader.nextInt();
		Q = Reader.nextInt();
		map = new HashMap<>();
		
		System.out.println(solve(N));
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"ms");
	}	
	
	public static long solve(long i) {
		if(i==0) return 1L;
		Long ret = map.get(i);
		if(ret != null)
			return ret;
		
		ret = solve(i/P)+solve(i/Q);
		map.put((long)i, ret);
		return ret;
	}
		
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		
		public static void init(InputStream input) throws Exception {
			reader = new BufferedReader(new InputStreamReader(input));
		}
		
		public static String next() throws Exception {
			while(tokenizer == null || !tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(reader.readLine());
			return tokenizer.nextToken();
		}
		
		public static String readLine() throws Exception{
			return reader.readLine();
		}
		
		public static int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		
		public static long nextLong() throws Exception {
			return Long.parseLong(next());
		}
		
	}
}
