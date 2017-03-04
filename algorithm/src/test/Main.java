package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {	
		
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());		
		que.add(4);
		que.add(5);
		System.out.println(que.poll());
		
	}
	
}


