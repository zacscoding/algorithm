package chap20.string.p10988;
/*

https://www.acmicpc.net/problem/10988

 */
import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		char[] s = Reader.next().toCharArray();
		
		System.out.println(isPelindrome(s));
	}
	
	public static int isPelindrome(char[] s) {
		int size = s.length;
		int n = size -1;
		size /=2;
		for(int i=0;i<size;i++,n--) {
			if(s[i] != s[n])
				return 0;
		}
		return 1;
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
