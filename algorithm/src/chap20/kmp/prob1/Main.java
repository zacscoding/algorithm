package chap20.kmp.prob1;

import java.io.FileInputStream;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2902
 */
public class Main {
	public static void main(String[] args) throws Exception {
		/**		input 	*/
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		
		for(int i=0;i<len;i++) {
			char ch = str.charAt(i);
			if(ch>='A' && ch<='Z')
				System.out.print(ch);
		}
	}
}
