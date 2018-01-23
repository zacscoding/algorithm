package chap08.dp.p1463;

import java.io.*;
import java.util.*;


/*

https://www.acmicpc.net/problem/1463

 */

public class Main {
	public static int[] dp;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		N = Reader.nextInt();
		if(N==1) {
			System.out.println(0);
		} else if(N <= 3) {
			System.out.println(1);
		} else {
			dp = new int[N+1];
			solve();
			System.out.println(dp[N]);
		}
	}
	
	//Buttom-up
	public static void solve() {
		dp[1] = 0;				
		for(int i=2;i<=N;i++) {
			int min = dp[i-1];			
			if(i%2 == 0)
				min = Math.min(min, dp[i/2]);
			if(i%3 == 0)
				min = Math.min(min, dp[i/3]);			
			dp[i] = min+1;
		}		
	}
	
	
	//Top-down
	// 1) n-1 
	// 2) n/2
	// 3) n/3
	public static int solve(int n) {
		if(n==1) return 0;
		if(dp[n] > 0) return dp[n];
		
		dp[n] = solve(n-1)+1;
		
		if(n%2 == 0) {
			int temp = solve(n/2)+1;
			if(dp[n] > temp) 
				dp[n] = temp;
		}
		
		if(n%3 == 0) {
			int temp = solve(n/3)+1;
			if(dp[n] > temp) 
				dp[n] = temp;
		}
		
		return dp[n];
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
