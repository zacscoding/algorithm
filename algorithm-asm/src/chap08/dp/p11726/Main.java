package chap08.dp.p11726;

/*

https://www.acmicpc.net/problem/11726

 */

import java.io.*;
import java.util.*;

public class Main {
	public static int MOD = 10007;
	public static int[] d = new int[1001];
	public static int N;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);		
		N = Reader.nextInt();		
		d[0] = 1;
		d[1] = 1;
		
		for(int i=2; i<=N; i++) {
			d[i] = d[i-1] + d[i-2];
			d[i] %=MOD;
		}
		System.out.println(d[N]);
		
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
