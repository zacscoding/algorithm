package chap17.partialsum.baekjoon.prob2;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Try5 {	
	public static int K,N;
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);		
		/**		input	*/
		N = sc.nextInt();
		K = sc.nextInt();		
		Queue<Integer> range = new LinkedList<>();
		int ret = 0, rangeSum = 0;		
		for(int i=0;i<N;i++) {
			int newSignal = sc.nextInt();
			rangeSum += newSignal;
			range.add(newSignal);			
			//구간의 합이 k를 초과하는 동안 구간에서 숫자를 뺸다.
			while( rangeSum > K) {
				rangeSum -= range.peek();
				range.poll();
			}			
			if(rangeSum == K)
				ret ++;
		}
		/**		output	*/
		System.out.println(ret);
	}	
}
