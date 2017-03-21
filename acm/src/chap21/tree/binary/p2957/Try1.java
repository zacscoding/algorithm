package chap21.tree.binary.p2957;
/*package chap22.binarytree.prob3;

import java.util.*;
import java.io.*;

class Node {
	int key;
	Node left;
	Node right;
	
	public Node(int key) {
		this.key = key;
	}
	
}

public class Try1 {
	static int C;
	static int N;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		N = Reader.nextInt();
		
		System.out.println(C);
		Node root = new Node(Reader.nextInt());				
		for(int i=1;i<N;i++) {
			insert(Reader.nextInt(),root);
			System.out.println(C);
		}
	}
	
	public static void insert(int x,Node n) {
		C++;		
		if(x < n.key) {
			if(n.left == null) n.left = new Node(x);
			else insert(x,n.left);
		} else {
			if(n.right == null) n.right = new Node(x);
			else insert(x,n.right);
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
		
		public static void close() throws IOException {
			if(reader != null)
				reader.close();
		}
		
	}
	

}
*/