package chap17.partialsum.p2015;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2015

input
6 1
1 2 -2 3 -3 5

output
4
 
 */

public class Try2 {
	public static int  N,K;
	public static int[] A;
	public static int[] psum;
	public static Map<Integer,List<Integer>> map;
	
	public static void main(String[] args) throws Exception {
		
		/**		input 	*/
		Scanner sc=new Scanner(new FileInputStream("input.txt"));	
		//Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		K = sc.nextInt();
		A = new int[N+1];
		psum = new int[N+1];
		psum[0] = A[0] = 0;		
		map = new HashMap<>(N+10,0.999999f);		
		List<Integer> list = new LinkedList<>();
		list.add(0);
		map.put(0, list);		
		for(int i=1;i<=N;i++) {
			A[i] = sc.nextInt();
			psum[i] = psum[i-1] + A[i];		
			
			List<Integer> idxList = map.get(psum[i]);
			if(idxList == null) {
				idxList = new LinkedList<>();				
				map.put(psum[i],idxList);
			}
			idxList.add(i);			
		}
		int ret = 0;		
		/**		output		*/
		for(int i=0;i<=N;i++) {
			int find = K + psum[i];
			List<Integer> idxList = map.get(find);
			if(idxList != null) {
				for(int j=0;j<idxList.size();j++) {
					if( idxList.get(j) > i)
						ret++;					
				}
			}
		}	
		
		System.out.println(ret);
		
				
	}	
}












