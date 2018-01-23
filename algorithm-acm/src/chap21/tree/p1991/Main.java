package chap21.tree.p1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

https://www.acmicpc.net/problem/1991

 */
public class Main {
	static Tree[] treeList;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);		
		int N = Reader.nextInt();		
		treeList = new Tree[26];		
		for(int i=0;i<N;i++) {
			String str = Reader.nextLine();
			int root = str.charAt(0)-'A';
			int left = str.charAt(2)- 'A';
			int right = str.charAt(4) - 'A';
			Tree.addTree(root, left, right);				
		}
		
		for(int i=1;i<4;i++) {
			print(treeList[0],i);
			System.out.println();
		}
		
	}		
	public static void print(Tree node, int order) {
		if(order ==1)
			System.out.print(node.ch);
		if(node.left != null)
			print(node.left,order);
		
		if(order ==2)
			System.out.print(node.ch);
		
		if(node.right != null)
			print(node.right,order);
		
		if(order ==3)
			System.out.print(node.ch);
	}
	
	
	static class Tree {
		char ch;
		Tree left;
		Tree right;		
		public Tree(char ch) {
			this.ch = ch;
		}				
		public static void addTree(int root,int left,int right) {
			if(treeList[root] == null)
				treeList[root] = new Tree((char)(root+'A'));
			if(left!= -19) {
				addNode(root,left,true);
			}			
			if(right !=-19) {
				addNode(root,right,false);
			}
		}		
		public static void addNode(int root,int child,boolean isLeft) {			
			if(treeList[child] == null)
				treeList[child] = new Tree((char)(child+'A'));
			
			if(isLeft)
				treeList[root].left = treeList[child];
			else
				treeList[root].right = treeList[child];
		}
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
