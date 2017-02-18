package chap17.partialsum.baekjoon.prob2;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Try3 {
	public static int  N,K;
	public static int[] A;
	public static int[] psum;
	public static Map<Integer,Integer> map;
	
	public static void main(String[] args) throws Exception {		
		/**		input 	*/
		Scanner sc=new Scanner(new FileInputStream("input.txt"));	
		//Scanner sc = new Scanner(System.in);		
		
		int test_case = sc.nextInt();
		while(test_case-- > 0) {
			N = sc.nextInt();
			K = sc.nextInt();		
			
			psum = new int[N+1];
			map = new HashMap<>(N+10,0.999999f);		
			
			psum[0] = 0;
			map.put(0, 1);
			
			int ret = 0;
			for(int i=1;i<=N;i++) {
				//psum 구하기
				int seq = sc.nextInt();
				psum[i] = psum[i-1] + seq;
							
				//psum[i] - K 찾기
				Integer count = map.get(psum[i]-K);			
				if(count != null) {
					ret += count; //갯수 ++				
				}			
				
				//psum[i]의 count ++
				int newVal = 1;
				Integer curCount = map.get(psum[i]);
				if(curCount != null)
					newVal += curCount;
				
				map.put(psum[i],newVal);
					
			}			
			/**		output		*/
			System.out.printf("-----------문제 N : %d , K : %d---------\n",N,K);
			for(int i=0;i<=N;i++) {
				System.out.print(i+"\t");
			}
			System.out.println();
			for(int i=0;i<=N;i++) {
				System.out.print(psum[i]+"\t");
			}
			System.out.println();			
			System.out.println("답 : "+ret);
			System.out.println("-------------------------");
		}
	}	
}




























