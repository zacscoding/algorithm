package chap20.suffixarray.prob3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*

https://www.acmicpc.net/problem/13013

 */
public class Try1 {
	public static char[] chArr;
	public static void main(String[] args) throws Exception {
		/*	input	*/
		Scanner sc = new Scanner(new FileInputStream("input.txt"));		
		String str = sc.next();		
		chArr = str.toCharArray();
		
		/*	output	*/
		Integer[] suffixArray = new Integer[str.length()];
		for(int i=0;i<suffixArray.length;i++) {
			suffixArray[i] = i;
		}
		
		Arrays.sort(suffixArray,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return str.substring(o1).compareTo(str.substring(o2));
			}			
		});			
		
		for(int i=0;i<suffixArray.length;i++)
			System.out.print((suffixArray[i]+1)+" ");
		System.out.print("\nx ");		
		for(int i=0;i<suffixArray.length-1;i++) {
			System.out.print(getLCP(suffixArray[i],suffixArray[i+1])+" ");  			
		}		
		sc.close();
	}
	
	public static int getLCP(int cur,int next) {		
		int ret = 0;
		int min = ( cur > next) ? chArr.length - cur : chArr.length - next;		
		for(int i=0;i<min;i++) {
			if(chArr[cur+i] == chArr[next+i]) 
				ret++; 
			else 
				break;
		}		
		return ret;
	}
	
	
	
	
}
