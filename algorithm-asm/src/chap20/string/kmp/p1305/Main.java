package chap20.string.kmp.p1305;

import java.util.Scanner;

/*
 Clear
 https://www.acmicpc.net/problem/1305
 광고
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String str = sc.next();
		int[] pi = getPartial(str);
		System.out.println(size-pi[size-1]);
	}
	
	public static int[] getPartial(String s) {
		int size = s.length();
		int[] pi = new int[size];
		int begin = 1, matched = 0;		
		while(begin + matched < size) {
			if(s.charAt(begin+matched) == s.charAt(matched)) {
				matched ++;
				pi[begin + matched -1] = matched;
			} else {
				if(matched == 0) {
					begin++;
				} else {
					begin += (matched - pi[matched-1]);
					matched = pi[matched-1];
				}
			}
		}
		
		return pi;		
	}

}
