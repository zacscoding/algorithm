package chap21.tree.binary.p1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Try1 {
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		int n = Reader.nextInt(),m=Reader.nextInt();		
		int common = 0;
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Reader.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<m;i++) {
			if(Arrays.binarySearch(arr,Reader.nextInt())>=0)
				common++;
		}
		System.out.println(n+m-(2*common));
		
	}
	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		
		public static void init(InputStream input) throws IOException {
			reader = new BufferedReader(new InputStreamReader(input));			
		}
		
		public static String nextLine() throws IOException {
			return reader.readLine();
		}
		
		public static String next() throws IOException {
			while(tokenizer==null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}		
	}
}
