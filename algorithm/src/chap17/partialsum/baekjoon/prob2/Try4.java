package chap17.partialsum.baekjoon.prob2;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Try4 {
	public static int  N,K;	
	public static long[] psum;
	public static Map<Long,Integer> map;
	
	public static void main(String[] args) throws Exception {		
		/**		input 	*/
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		K = sc.nextInt();

		psum = new long[N + 1];
		map = new HashMap<>(N + 10, 0.999999f);

		psum[0] = 0;
		map.put((long) 0, 1);

		int ret = 0;
		for (int i = 1; i <= N; i++) {
			// psum 구하기
			int seq = sc.nextInt();
			psum[i] = psum[i - 1] + seq;

			// psum[i] - K 찾기
			Integer count = map.get(psum[i] - K);
			if (count != null) {
				ret += count; // 갯수 ++
			}

			// psum[i]의 count ++
			int newVal = 1;
			Integer curCount = map.get(psum[i]);
			if (curCount != null)
				newVal += curCount;

			map.put(psum[i], newVal);

		}
		/** output */
		System.out.println(ret);
		sc.close();
	}	
}




























