package chap17.partialsum.p2015;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Try1 {
	public static int N;
	public static int K;
	public static int[] A;
	public static int[] psum;
	public static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		//Scanner sc=new Scanner(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);				

		que.clear();		
		N = sc.nextInt();
		K = sc.nextInt();		
		int count = 0;		
		A = new int[N+1];
		psum = new int[N+1];		
		psum[0] = A[0] = 0;	
		for(int i=1;i<=N;i++) {
			A[i] = sc.nextInt();
			if(A[i]<0)
				que.add(i);			
			psum[i] = psum[i-1] + A[i];
		}		

		while(!que.isEmpty()) {
			int curIdx = que.poll();
			count += left(curIdx);
			if(!que.isEmpty()) 
				count += right(curIdx,que.peek());
		}
		
		System.out.println(count);										
		sc.close();
	}	
	public static int left(int idx) {		
		int ret = 0;		
		for(int i=1;i<idx;i++) {
			if(psum[idx] - psum[i-1] == K)
				ret++;
		}		
		return ret;
	}	
	public static int right(int idx,int next) {
		int ret = 0;
		for(int i=1;i<=idx;i++) {
			for(int j=idx+1;j<next;j++) {
				if(psum[idx] - psum[i-1] == K)
					ret++;
			}			
		}		
		return ret;
	}
}