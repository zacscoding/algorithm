package chap20.naming;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 무식하게 풀기
 */

public class Try2 {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
       	/**	input	*/     
    	String pre = sc.next();
    	String suff = sc.next();
        List<Integer> result = getPrefixSuffix(pre+suff);
        for(int i=result.size()-1;i>=0;i--)
        	System.out.print(result.get(i)+" ");
        /**	output	*/
        sc.close();    	
    }
    
    //s의 접두사도 되고 접미사도 되는 문자열의 길이를 반환
    public static List<Integer> getPrefixSuffix(String s) {    	
    	int[] pi = getPartialMatch(s);
    	int k = s.length();
    	List<Integer> ret = new ArrayList<>(k);
    	
    	while(k>0) {
    		//s[..k-1]는 답이다
    		ret.add(k);    		
    		// s[..k-1]의 접미사도 되고, 접두사도 되는 문자열도 답
    		k = pi[k-1];    		
    	}
    	return ret;
    }
    
    public static int[] getPartialMatch(String N) {
		int m = N.length();
		int[] pi = new int[m];		
		int begin = 1, matched = 0;
		
		while(begin+matched < m) {
			if(N.charAt(begin+matched) == N.charAt(matched)) {
				matched ++;
				pi[begin + matched -1] = matched;
			} else {
				if(matched == 0) {
					begin ++;					
				} else {
					begin += (matched - pi[matched-1]);
					matched = pi[matched -1];
				}	
			}			
		}
		return pi;
	}
    
    
}
