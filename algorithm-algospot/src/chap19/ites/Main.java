package chap19.ites;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class RNG {
	static final long MOD = (long)Math.pow(2,32);
	long seed;
	public RNG() {
		seed = 1983L;
	}	
	public long next() {
		long ret = seed;
		seed = ((seed * 214013L) + 2531011L) % MOD;
		return ret % 10000 +1;		
	}
}

public class Main {
	public static int N;
	public static int K;
		
	public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        
        	/**		input		*/        	
        	K = sc.nextInt();
        	N = sc.nextInt();        	        		    	
        	/**		output		*/
        	System.out.println(countRanges(K,N));
        	
        }
        sc.close();
	}
	
	public static int countRanges(int k,int n) {
		RNG rng = new RNG();
		Queue<Integer> range = new LinkedList<>();
		int ret = 0, rangeSum = 0;
		
		for(int i=0;i<n;i++) {
			int newSignal = (int)rng.next();
			rangeSum += newSignal;
			range.add(newSignal);
			
			//구간의 합이 k를 초과하는 동안 구간에서 숫자를 뺸다.
			while( rangeSum > k) {
				rangeSum -= range.peek();
				range.poll();
			}
			
			if(rangeSum == k)
				ret ++;
		}
		
		return ret;
	}
}


/*

input

3
8791 20
5265 5000
3578452 5000000

output

1
4
1049

*/

