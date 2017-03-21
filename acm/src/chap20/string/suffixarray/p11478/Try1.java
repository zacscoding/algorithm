package chap20.string.suffixarray.p11478;

import java.util.Scanner;

public class Try1 {
	
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
//		System.out.println(solve(sc.next().toCharArray()));
//		sc.close();
		String str = "aabaa";
		System.out.println(solve(str.toCharArray()));
	}	
	public static int solve(char[] s) {
		//전체 부분 집합 개수
		int size = s.length;
		int ret = size*(size+1)/2;
		
		int begin = 1, matched = 0;
		while(begin+matched < size) {
			if((s[begin+matched] == s[matched]) ) {
				matched++;
			} else {
				if(matched == 0) {
					begin++;
				} else {
					//ret에서 빼주고
					ret-= (matched*(matched+1)/2);
					begin += (matched+1);
					matched = 0;
				}			
			}			
		}
		ret-= (matched*(matched+1)/2);
		
		return ret;
	}
}
