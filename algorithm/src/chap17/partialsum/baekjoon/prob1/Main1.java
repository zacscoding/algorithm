package chap17.partialsum.baekjoon.prob1;

import java.io.FileInputStream;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1806
 */
public class Main1 {
	public static int N;
	public static int S;
	public static int[] seq;	
	public static int[] psum;
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		
		//문제		
		N = sc.nextInt();
		S = sc.nextInt();		
		seq = new int[N];
		psum = new int[N];
		
		psum[0] = seq[0] = sc.nextInt();		
		for(int i=1;i<N;i++) {
			seq[i] = sc.nextInt();
			psum[i] = psum[i-1] + seq[i];
		}				
		//정답			
		System.out.println(solve(psum));				
		sc.close();
	}	
	
	public static int solve(int[] psum) {
		//기저
		if(psum[N-1]<S)
			return 0;		
		
		int cnt = 0;
		A:while(cnt < N) {
			for(int i=1;i<N;i++) {
				if( (i+cnt)<N && psum[i+cnt] - psum[i-1] >= S)
					break A;				
			}		
			cnt++;
		}	
		return cnt+1;
	}
}
