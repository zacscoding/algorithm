package chap20.naming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 무식하게 풀기
 */

public class Try1 {
	public static String pre,suf;
    public static void main(String[] args) throws Exception {
    	//Scanner sc = new Scanner(new FileInputStream("input.txt"));	
        Scanner sc = new Scanner(System.in);
        
        String input = new StringBuilder()
        		.append(sc.next()).append(sc.next()).toString();                	
        /**	output	*/
        List<Integer> list = getPreAndSuffix(input);
        for(int i=0;i<list.size();i++) 
        	System.out.print(list.get(i)+" ");
        
        sc.close();    	
    }
    
    public static List<Integer> getPreAndSuffix(String N) {
    	int size = N.length();
    	List<Integer> ret = new ArrayList<>();
    	
    	for(int i=0; i<size;i++) {
    		boolean matched = true;
    		for(int j=0,right=size-1-i;j<=i;j++) {
    			if(N.charAt(j) != N.charAt(right+j)) {
    				matched = false;
    				break;
    			}
    		}
    		
    		if(matched)
    			ret.add(i+1);
    	}    	
    	return ret;
    }
    
    
    
    
}
