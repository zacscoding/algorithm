package chap22.binarytree.insertion;

import java.io.*;
import java.util.*;

/*

https://algospot.com/judge/problem/read/INSERTION
 */


class Node {
	int key,priority,size;
	Node left;
	Node right;	
	public Node(int key) {
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
		if(left != null) size +=left.size;
		if(right != null) size +=right.size;
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

public class Main {
	static int n;
	static int[] shifted = new int[50000];
	static int[] A = new int[50000];
	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		int cases = Reader.nextInt();
		
		while( cases-- > 0) {
			/**		input		*/
			n = Reader.nextInt();
			for(int i=0;i<n;i++) {
				shifted[i] = Reader.nextInt();
			}
			
			/**		output		*/
			solve();
			for(int i=0;i<n;i++) {
				System.out.print(A[i]+" ");
			}			
			System.out.println();
		}		
		Reader.close();
	}
	
	public static void solve() {
		Node candidates = null;
		for(int i=0;i<n;i++) 
			candidates = insert(candidates,new Node(i+1));
		
		for(int i=n-1;i>=0;i--) {
			int larger = shifted[i];
			Node k = kth(candidates,i+1-larger);
			A[i] = k.key;
			candidates = erase(candidates,k.key);
		}		
	}
	
	public static Node insert(Node root,Node node) {
		if(root == null) return node;		
		
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
	
	public static NodePair split(Node root, int key) {
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
	
	
	public static Node merge(Node a,Node b) {
		if(a == null) return b;
		if(b == null) return a;
		
		if(a.priority < b.priority) {
			b.setLeft(merge(a,b.left));
			return b;
		}
		
		a.setRight(merge(a.right,b));
		return a;			
	}
		
	public static Node erase(Node root,int key) {
		if(root == null) return root;
		
		if(root.key == key) {
			return merge(root.left,root.right);
		}
		
		if(key < root.key)
			root.setLeft(erase(root.left,key));
		else
			root.setRight(erase(root.right,key));
		return root;
	}
	
	
	
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
		
		static void init(InputStream input) throws IOException {
			reader = new BufferedReader(new InputStreamReader(input));
		}
		
		static String next() throws IOException {
			while(tokenizer == null || !tokenizer.hasMoreElements()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static String nextLine() throws IOException {
			return reader.readLine();
		}
		
		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		static void close() throws IOException {
			if(reader!=null) reader.close();
		}
	}
}



/*

input

2
5
0 1 1 2 3
4
0 1 2 3


output

5 1 4 3 2
4 3 2 1


*/