package chap18.josephus;
/*
 https://algospot.com/judge/problem/read/JOSEPHUS
 */
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int K;
	public static List<Integer> suvivor = new LinkedList<>();
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	//문제
        	suvivor.clear();
        	N = sc.nextInt();
        	K = sc.nextInt();
        	for(int i=0;i<N;i++) {
        		suvivor.add(i+1);
        	}   
        	int idx = 0;        	
        	//정답
        	while(suvivor.size() > 2) {        		
        		suvivor.remove(idx);
        		idx = (idx + K -1) % suvivor.size();
        	}       	
        	
        	int max = suvivor.get(0);
        	int min = suvivor.get(1);
        	if(max < min) {
        		int temp = max;
        		max = min;
        		min = temp;
        	}        	
        	System.out.println(min+" "+max);        	
        }
        sc.close();
    }
}


/*
input
 
2
6 3
40 3

output

3 5
11 26

*/