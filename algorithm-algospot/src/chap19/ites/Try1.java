package chap19.ites;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//
//
//class RNG {
//	static final long MOD = (long)Math.pow(2,32);
//	long seed;
//	public RNG() {
//		seed = 1983L;
//	}	
//	public long next() {
//		long ret = seed;
//		seed = ((seed * 214013L) + 2531011L) % MOD;
//		return ret % 10000 +1;		
//	}
//}
//
//public class Try1 {
//	public static int K;
//	public static int N;	
//	public static void main(String[] args) throws Exception {
//    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        //Scanner sc = new Scanner(System.in);
//        int cases = sc.nextInt();
//        while(cases-- > 0) {
//        	/**		input		*/        	
//        	K = sc.nextInt();
//        	N = sc.nextInt();        	
//        	Map<Long,Integer> map = new HashMap<>();
//        	RNG rng = new RNG();        	
//        	int ret = 0;
//        	long curPsum = 0;
//        	map.put(0L,1);
//        	for(int i=1;i<=N;i++) {
//        		curPsum += rng.next();
//        		Integer prevCount = map.get(curPsum - K);
//        		if(prevCount != null) {
//        			ret += prevCount;
//        		}        		
//        		int newVal = 1;
//        		Integer curCount = map.get(curPsum);
//        		if(curCount!=null)
//        			newVal += curCount;
//        		map.put(curPsum,curCount);
//        	}        	      	
//        	/**		output		*/
//        	System.out.println(ret);        	
//        }
//        sc.close();
//    }
//
//}