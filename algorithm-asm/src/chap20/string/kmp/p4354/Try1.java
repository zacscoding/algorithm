package chap20.string.kmp.p4354;

import java.io.FileInputStream;
import java.util.Scanner;

public class Try1 {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
    	 while(true) {
         	/**	input	*/
         	String s = sc.next();
         	if(s.charAt(0)=='.')
         		break;
         	int size = s.length();
         	
        	/**	output	*/
         	System.out.println(solve(s,size));         	
         }	
        sc.close();        
    }
    
    public static int solve(String s,int size) {    	
    	for(int i=1;i<size-1;i++) { //정답 가능성 개수(사이즈 약수)
    		if(size%i==0) { //a가 i개로 정답이 될 수 있는지 체크
    			for(int j=0;j<size;j++) {
    				if(j == size-i)
    					return size/i;
    				if(s.charAt(j) != s.charAt(i+j))
    					break;    				
    			}    				
    		}    		
    	}
    	return 1;
   }
}
















