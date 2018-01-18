package chap20.string.suffixarray.p13275;

import java.util.Scanner;

/*
not yet clear
https://www.acmicpc.net/problem/13275
 */
public class Main {
	
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String r = new StringBuilder(s).reverse().toString();		
		int size = s.length();
		int result = 1;				
		for(int i=0; i<size-1;i++) {
			int matched = 0;
			for(int j=0;j+i<size;j++) {
				if(s.charAt(i+j) == r.charAt(j))
					matched++;
			}			
			if(matched != 0) {
				result = result > matched ? result : matched;
			}
			if(matched >= size-i)
				break;
		}		
		System.out.println(result);	*/
		
		String s = "dcabccd";
		String r = new StringBuilder(s).reverse().toString();
		int[] pi = getPartialMatch(r);
		for(int i=0;i<pi.length;i++) {
			System.out.println(i+" : "+pi[i]);
		}
		
		
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
