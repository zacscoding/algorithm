package chap21.traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static int[][] tree;
	
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		
		tree = new int[26][];
		for(int i=0;i<tree.length;i++) {
			tree[i] = new int[2];
		}		
		int n = Reader.nextInt();
		
		for(int i=0;i<n;i++) {
			String str = Reader.nextLine();			
			int root = str.charAt(0)-'A';
			int left = str.charAt(2);
			int right = str.charAt(4);
			
			if(left == '.') left = -1;
			else  left -= 'A';
			tree[root][0] = left;
			
			if(right == '.') right = -1;
			else right -= 'A';
			tree[root][1] = right;			
		}
		
		preOrder(0);System.out.println();
		inOrder(0);System.out.println();
		postOrder(0);System.out.println();
		
		
	}
	
	public static void preOrder(int idx) {
		if(idx == -1) return;
		System.out.printf("%c",(idx+'A'));
		preOrder(tree[idx][0]);
		preOrder(tree[idx][1]);
	}
	
	public static void inOrder(int idx) {
		if(idx == -1) return;
		inOrder(tree[idx][0]);
		System.out.printf("%c",(idx+'A') );
		inOrder(tree[idx][1]);
	}
	
	public static void postOrder(int idx) {
		if(idx == -1) return;
		postOrder(tree[idx][0]);
		postOrder(tree[idx][1]);
		System.out.printf("%c",(idx+'A'));
	}
	

	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		
		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}
		
		static String next() throws IOException {
			while( !tokenizer.hasMoreTokens() ) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static String nextLine() throws IOException {
			return reader.readLine();
		}
		
		static int nextInt() throws IOException {
			return Integer.parseInt( next() );
		}
		
		static void close() throws IOException {
			if(reader != null)
				reader.close();
		}
		
	}
}
