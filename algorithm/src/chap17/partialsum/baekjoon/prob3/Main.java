package chap17.partialsum.baekjoon.prob3;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
not yet clear
https://www.acmicpc.net/problem/2143

 */
public class Main {
	static int T;
	static int n,m;
	static Map<Integer,Integer> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));		
		T = sc.nextInt();		
		n = sc.nextInt();		
		int[] psum = new int[n+1];
		map = new HashMap<>(n+10,0.999999f);		
		psum[0] = 0;
		int seq = 0;
		for(int i=1;i<=n;i++) {
			seq = sc.nextInt();
			psum[i] = psum[i-1] + seq;
			for(int j=0;j<i;j++) {
				int res = psum[i] - psum[j];
				int newVal = 1;
				Integer cnt = map.get(res);
				if(cnt != null)
					newVal += cnt;
				map.put(res, newVal);				
			}			
		}		
		
		m = sc.nextInt();
		int res = 0;
		int[] psum2 = new int[m+1];		
		psum2[0] = 0;
		int seq2 = 0;
		
		for(int i=1;i<=m;i++) {
			seq2 = sc.nextInt();
			psum2[i] = psum2[i-1] + seq2;
			for(int j=0;j<i;j++) {
				int secPsum = psum2[i] - psum2[j];
				if(secPsum >= T)      
					continue;
				Integer cnt = map.get(T-secPsum);
				if(cnt != null)
					res+=cnt;
			}
			
		}		
		System.out.println(res);
		sc.close();
	}
}
