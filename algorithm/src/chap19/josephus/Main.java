package chap19.josephus;

/*
https://algospot.com/judge/problem/read/JOSEPHUS
 */
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://algospot.com/judge/problem/read/JOSEPHUS
 */
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {	
	public static int N;
	public static int K;	
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		 int cases = sc.nextInt();
		 while(cases-- > 0) {
			/**		input	*/
			N = sc.nextInt();
			K = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();			
			for(int i=1;i<=N;i++) {
				queue.add(Integer.valueOf(i));
			}		
			/**		output	*/
			while(queue.size()>2) {
				queue.poll();
				for(int i=1;i<K;i++) {					
					queue.add(queue.poll());
				}
			}	
			int max = queue.poll();
			int min = queue.poll();
			if(max < min) {
				int temp = max;
				max = min;
				min = temp;
			}			
			System.out.println(min+" "+max);						
		}				
	}
}
















