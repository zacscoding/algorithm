package chap19.ites;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int K;
		
	public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	/**		input		*/
        	K = sc.nextInt();
        	N = sc.nextInt();
        	Map<Integer,Integer> map = new HashMap<>();
        	
        	int prevNum = 1983;
        	int prevPsum = 1983;
        	int ret = 0;
        	for(int i=1;i<=N;i++) {
        		
        		
        	}        	
        	/**		output		*/
        	
        }
        sc.close();
    }

}


/*

input

3
8791 20
5265 5000
3578452 5000000

output

1
4
1049

*/

