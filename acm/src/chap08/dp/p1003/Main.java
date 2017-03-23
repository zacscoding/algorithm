package chap08.dp.p1003;

/*

https://www.acmicpc.net/problem/1003

 */

import java.io.*;
import java.util.*;

public class Main {	
	public static int[][] dp = new int[41][2];	
	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);				
		int cases = Reader.nextInt();
		
		dp[0][0] = dp[1][1] = 1;		
		
		for(int i=2; i<41; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		while(cases-- > 0) {
			int n = Reader.nextInt();
			System.out.println(dp[n][0]+" "+dp[n][1]);
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

