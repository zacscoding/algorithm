package chap23.priority.p2014;

import java.util.*;


import java.io.*;


class Node {
	long key;	
	int priority,size;
	
	Node left;
	Node right;
	
	public Node(long key) {
		this.key = key;
		this.size = 1;
		priority = (int)(Math.random()*100); //0~100
	}
	
	public void setLeft(Node left) {
		this.left = left;
		calcSize();
	}
	
	public void setRight(Node right) {
		this.right = right;
		calcSize();
	}	
	
	private void calcSize() {
		size = 1;
		if(left != null)
			size +=left.size;
		if(right != null)
			size +=right.size;
	}	
}

class NodePair {
	Node first;
	Node second;
	public NodePair(Node f,Node s) {
		first = f;
		second = s;
	}
}

public class Try1 {
	static int K;
	static int N;
	static long[] prime;
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		
		K = Reader.nextInt();
		N = Reader.nextInt();
		prime = new long[K];
		
		prime[0] = Reader.nextInt();
		Node root = insert(null,new Node(prime[0]));
		root = insert(root,new Node(prime[0] * prime[0]));
				
		for(int i=1;i<K;i++) {
			prime[i] = Reader.nextLong();
			root = insert(root,new Node(prime[i]));
			for(int j=0;j<=i;j++) {
				root = insert(root,new Node(prime[i] * prime[j]));
			}			
		}
		
		System.out.println(kth(root, N).key);
	}
	
	
	
	
	public static Node insert(Node root,Node node) {
		if(root == null) return node;	
		
		if(root.key == node.key)
			return root;
		
		if(root.priority < node.priority) {
			NodePair pair = split(root,node.key);
			node.setLeft(pair.first);
			node.setRight(pair.second);
			return node;
		} else if(node.key < root.key) {
			root.setLeft(insert(root.left,node));
		} else {
			root.setRight(insert(root.right,node));
		}
		return root;
	}	
	public static NodePair split(Node root, long key) {
		if(root == null) return new NodePair(null,null);
		
		if(root.key < key) {
			NodePair rs = split(root.right,key);
			root.setRight(rs.first);
			return new NodePair(root,rs.second);			
		}
		
		NodePair ls = split(root.left,key);
		root.setLeft(ls.second);
		return new NodePair(ls.first,root);
	}	
	
	//k번째 원소 찾기
	public static Node kth(Node root,int k) {
		int leftSize = 0;
		if(root.left != null)
			leftSize = root.left.size;
		
		if(k <= leftSize) return kth(root.left,k);
		if(k == leftSize+1) return root;
		return kth(root.right,k-leftSize-1);		
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
		
		public static long nextLong() throws Exception {
			return Long.parseLong( next() );
		}
	}	
	

}
