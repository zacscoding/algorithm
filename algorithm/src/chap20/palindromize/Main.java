package chap20.palindromize;

import java.io.FileInputStream;
import java.util.Scanner;

/*
Clear
https://algospot.com/judge/problem/read/PALINDROMIZE
 */
public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	/**	input	*/
        	char[] S1 = sc.next().toCharArray();
        	int length = S1.length;
        	char[] S2 = new char[length];
        	for(int i=0; i<length;i++) {
        		S2[i] = S1[length-i-1];
        	}        	
        	/**	output	*/
        	System.out.println(2*length-maxOverlap(S1,S2));        	
        }        
        sc.close();        
    }
    
    //a의 접미사이면서 b의 접두사인 문자열의 최대 길이를 구한다.
    public static int maxOverlap(char[] a,char[] b) {    	
    	int n = a.length,m=b.length;
    	
    	int[] pi = getPartialMatch(b);
    	//begin = matched = 0 에서부터 시작
    	int begin=0,matched=0;
    	
    	while(begin < n) {
    		//만약 짚 더미의 해당 글자가 바늘의 해당 글자와 같다면
    		if(matched < m && a[begin+matched] == b[matched]) {
    			matched++;
    			if(begin + matched == n)
    				return matched;
    		} else {
    			if(matched == 0) {
    				begin++;
    			} else {
    				begin += (matched - pi[matched-1]);
    				matched = pi[matched - 1];
    			}
    		}
    	}
    	return 0;
    }
    
    public static int[] getPartialMatch(char[] N) {
		int m = N.length;
		int[] pi = new int[m];
		
		//KMP로 자기 자신을 찾는다.
		//N을 N에서 찾는다. begin=0이면 자기 자신을 찾아버리니까 안됨
		int begin = 1, matched = 0;
		//비교할 문자가 N의 끝에 도달할 때까지 찾으면서 부분 일치를 모두 기록한다.
		while(begin+matched < m) {
			if(N[begin+matched] == N[matched]) {
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