package chap08.dp.p1446;
/*

https://www.acmicpc.net/problem/2133

 */
import java.io.*;
import java.util.*;

public class Main {
	public static int[] d = new int[31];
	public static int[] g = new int[31];
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);		
		int n = Reader.nextInt();		
		d[0]=1;
		g[1]=1;		
		for(int i=2;i<=n;i++) {
			g[i] = d[i-1] + g[i-2];
			d[i] = d[i-2] + 2*g[i-1];
		}			
				                         
		System.out.println(d[n]);
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
