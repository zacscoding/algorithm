package chap23.priorityquenheap.runningmedian;

import java.io.*;
import java.util.*;


/*

https://algospot.com/judge/problem/read/RUNNINGMEDIAN

 */

/*
class Node {
	int key;
	int priority,size;	
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

class RNG {	
	int a,b,seed;
	RNG(int a,int b) {
		this.a = a;
		this.b = b;
		seed = 1983;
	}
	
	public int next() {
		int ret = seed;
		seed = (int) ( ((seed*(long)a)+b)%20090711 );
		return ret;
	}
}

public class Main2 {
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		int cases = Reader.nextInt();
		while(cases-->0) {
			int n = Reader.nextInt();
			RNG rng = new RNG(Reader.nextInt(),Reader.nextInt());
			System.out.println(runningMedian(n,rng));
		}			
	}
	
	//rng가 생성하는 첫 n개의 난수를 수열에 추가하며 중간 값 계산
	public static int runningMedian(int n,RNG rng) {
		Node root = null;
		final int MOD = 20090711;
		int ret = 0;
		for(int cnt = 1;cnt <=n;cnt++) {
			root = insert(root,new Node(rng.next()));
			int median = kth(root,(cnt + 1) /2).key;
			ret = (ret + median) % MOD;
		}
		return ret;
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
	
			merge		
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
	
	
			erase		
	public static Node erase(Node root,int key) {
		if(root == null) return root;
		
		//root를 지우고 양 서브트리를 합친 뒤 반환
		if(root.key == key) {
			return merge(root.left,root.right);
		}
		
		if(key < root.key)
			root.setLeft(erase(root.left,key));
		else
			root.setRight(erase(root.right,key));
		return root;
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
	
	//X보다 작은 원소 세기
	public static int countLessThan(Node root,int key) {
		if(root==null) return 0;
		
		if(root.key >= key) {
			return countLessThan(root.left,key);
		}		
		int ls = (root.left != null) ? root.left.size : 0;
		return ls + 1 + countLessThan(root.right,key);		
	}
	
	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		static void init(InputStream input) throws Exception {
			reader = new BufferedReader(new InputStreamReader(input));
		}
		
		static String next() throws Exception {
			while(tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		static String nextLine() throws Exception {
			return reader.readLine();
		}
		
		static int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
		
	}
}*/
