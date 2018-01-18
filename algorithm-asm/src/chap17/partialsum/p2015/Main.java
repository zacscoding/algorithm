package chap17.partialsum.p2015;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2015

input
4
4 0
2 -2 2 -2
6 1
1 2 -2 3 -3 5
7 3
3 -4 5 1 -4 -6 2
8 1
1 2 3 -3 4 5 -6 7

output
4 
 */

public class Main {	
	public static int  N,K;	
	public static Map<Long,Integer> map;
	public static void main(String[] args) throws Exception {
		/**		input 	*/
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new HashMap<>();

		long psum = 0L;
		map.put(psum, 1);
		long ret = 0;
		for (int i = 1; i <= N; i++) {
			// psum 구하기
			int seq = sc.nextInt();
			psum += seq;
			
			// psum[i] - K 찾기
			Integer count = map.get(psum - K);
			if (count != null) {
				ret += count; // 갯수 ++
			}

			// psum[i]의 count ++
			int newVal = 1;
			Integer curCount = map.get(psum);
			if (curCount != null)
				newVal += curCount;

			map.put(psum, newVal);
		}
		/** output */
		System.out.println(ret);
		sc.close();
		
	}

}
