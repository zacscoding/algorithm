package chap18.fence;

/*
 https://algospot.com/judge/problem/read/FENCE
 */
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Try1 {
	public static int N;
	public static int[] fence;
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	/** 	input	*/
        	N = sc.nextInt();
        	fence = new int[N];
        	for(int i=0;i<N;i++)
        		fence[i] = sc.nextInt();
        	Stack<Integer> stack = new Stack<>();
        	
        	
        	
        	/** 	output	*/
        	        	
        }
        sc.close();
    }
}


/*
input
 
3
7
7 1 5 9 6 7 3
7
1 4 4 4 4 1 1
4
1 8 2 2

output

20
16
8

*/
