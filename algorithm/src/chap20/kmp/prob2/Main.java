package chap20.kmp.prob2;

import java.io.FileInputStream;
/*
https://www.acmicpc.net/problem/4354
 */
import java.util.Scanner;

public class Main {
   public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
       // Scanner sc = new Scanner(System.in);
    	 while(true) {
         	/**	input	*/
         	char[] s = sc.next().toCharArray();
         	if(s[0] == '.')
         		break;         	
        	/**	output	*/
         	System.out.println(solve(s));         	
         }	
    	 sc.close();
   }
   public static int solve(char[] s) {  
        int size = s.length;
    	for(int i=1;i<size;i++) { //정답 가능성 개수(사이즈 약수)
    		if(size%i==0) { //a가 i개로 정답이 될 수 있는지 체크
    			for(int j=0;j+i<=size;j++) {
    				if(j == size-i)
    					return size/i;
    				if(s[j] != s[i+j])
    					break;    				
    			}    				
    		}    		
    	}
    	return 1;
   }     
}
















