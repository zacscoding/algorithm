package test;

import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		for(int i=1;i<5;i++) {
			map.put(i, i);
		}
		
		System.out.println(map.higherKey(3));
		System.out.println(map.lowerKey(3));
		
		
		
	}
	
}


