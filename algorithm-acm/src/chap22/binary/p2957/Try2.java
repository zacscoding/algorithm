package chap22.binary.p2957;

import java.io.*;
import java.util.*;

class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int val) {
		value = val;
	}
}

public class Try2 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		N = Reader.nextInt();
		int cnt = 0;
		Node root = new Node(Reader.nextInt());
		System.out.println(cnt);
		
		Node next = null;
		Node prev = null;
		boolean isInserted = false;
		for(int i=1; i<N; i++) {
			int newVal = Reader.nextInt();
			isInserted = false;
			prev = root;
			if(root.value < newVal)
				next = root.right;
			else
				next = root.left;
			cnt++;
			while(next != null) {
				prev = next;
				if(next.value < newVal) {
					if(next.right == null) {
						next.right = new Node(newVal);
						System.out.println(cnt);
						isInserted = true;
						break;
					}else {
						next = next.right;						
					}
				} else{
					if(next.left == null) {
						next.left = new Node(newVal);
						System.out.println(cnt);
						isInserted = true;
						break;
					} else {
						next = next.left;						
					}
				}
				cnt++;
			}
			if(!isInserted) {
				if(prev.value < newVal)
					prev.left = new Node(newVal);
				else
					prev.right = new Node(newVal);
				System.out.println(cnt);
			}
			
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
