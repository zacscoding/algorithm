package chap20.string.kmp.p4354;

import java.io.FileInputStream;
import java.util.Scanner;
public class Try2 {
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
    	boolean lastFlag = false;
        while(true) {
        	/**	input	*/
        	String input = sc.next();
        	int size = input.length();
        	if(input.charAt(size-1) == '.') {
        		lastFlag = true;
        	}
        	int[] pi = getPartialMatch(input);
        	
        	/**	output	*/        	
        	if(lastFlag)
        		break;
        }
    }
    
    public static int[] getPartialMatch(String N) {
    	int m = N.length();
    	int[] pi = new int[m];
    	
    	int begin = 1, matched = 0;
    	while(begin+matched < m) {
    		if(N.charAt(begin+matched) == N.charAt(matched)) {
    			matched ++;
    			pi[begin+matched] = matched;
    		} else {
    			if(matched ==0) {
    				begin ++;    				
    			} else {
    				begin += (matched - pi[matched-1]);
    			}
    		}
    	}
    	return pi;
    }
    
    
}
