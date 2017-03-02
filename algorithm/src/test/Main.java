package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer val1, Integer val2) {
				int comp = Math.abs(val1) - Math.abs(val2);
				
				if(comp == 0) {
					if(val1 < 0)
						return -1;
					else 
						return 1;
				}
				return comp;					
			}			
		});		
		que.offer(-1);
		que.offer(-2);
		
		System.out.println(que.poll());
		
	}
	
}


