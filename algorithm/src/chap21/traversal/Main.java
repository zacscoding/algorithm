package chap21.traversal;

import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;


/*

Solved
https://algospot.com/judge/problem/read/TRAVERSAL

 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	/**	input	*/
        	int N = sc.nextInt();
        	int[] pre = new int[N];
        	int[] in = new int[N];
        	
        	for(int i=0;i<N;i++) {
        		pre[i] = sc.nextInt();
        	}        	
        	for(int i=0;i<N;i++) {
        		in[i] = sc.nextInt();
        	}
        	
        	/**	output	*/
        	printPostOrder(pre,in);
        	System.out.println();
        }
        
        sc.close();  
	}
	
	public static void printPostOrder(int[] preorder,int[] inorder) {
		int N = preorder.length;		
		if(N == 0)
			return;		
		int root = preorder[0];
		int L = 0;
		for(int i=0;i<inorder.length;i++) {
			if(inorder[i] == root) {
				L = i;
				break;
			}
		}		
		//int R = N-1-L;		
		printPostOrder(slice(preorder,1,L+1), slice(inorder,0,L));
		printPostOrder(slice(preorder,L+1,N), slice(inorder,L+1,N) );
		System.out.print(root+" ");
	}	
	public static int[] slice(int[] a, int i ,int j) {
		int size = j-i;
		int[] ret = new int[size];
		for(int k=0;k<size;k++) {
			ret[k] = a[i+k];
		}
		return ret;
	}
	
	public static void printPostOrder(List<Integer> pre,List<Integer> in) {
		if(pre.isEmpty()) 
			return;		
		int root = pre.get(0);		
		int idx = 0;
		for(int i=0;i<in.size();i++) {
			if(root == in.get(i)) {
				idx = i;
				break;
			}
		}		
		printPostOrder(pre.subList(1,idx+1),in.subList(0, idx));
		printPostOrder(pre.subList(idx+1,pre.size()),in.subList(idx+1,in.size()));		
		System.out.print(root+" ");
	}
	
	
	
}











/*
input

2
7
27 16 9 12 54 36 72
9 12 16 27 36 54 72
6
409 479 10 838 150 441
409 10 479 150 838 441



output
12 9 16 36 72 54 27
10 150 441 838 479 409



*/