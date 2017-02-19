package chap17.partialsum.maxsum;

import java.io.FileInputStream;
import java.util.Scanner;

/*
미완
-if ( maxIdx == minId ) == true???

 */
public class Try1 {
	public static int N;
	public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	N = sc.nextInt();
        	long psum = 0;
        	long max = Integer.MIN_VALUE;
        	long min = 0;
        	for(int i=1;i<=N;i++) {
        		long seq = sc.nextLong();
        		psum += seq;
        		
        		if(psum > max) {
        			max = psum;
        		} else {
        			if(psum < min)
        				min = psum;
        		}
        	}
        	long result = (max-min > 0) ? (max-min) : 0;
        	System.out.println((result));
        }
        sc.close();
    }
}
