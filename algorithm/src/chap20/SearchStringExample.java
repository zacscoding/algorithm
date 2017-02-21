package chap20;

import java.util.ArrayList;
import java.util.List;

public class SearchStringExample {
	
	public static void main(String[] args) {
		
		String H = "avava";
		String N = "ava";
		List<Integer> idxList = naiveSearch(H,N);
		
		for(int i=0;i<idxList.size();i++) {
			System.out.println("idx : "+idxList.get(i));
		}
		
		System.out.println(H.indexOf(N ));
		
	}
	
	//'짚더미' H의 문자열로 '바늘' N이 출현하는 시작 위치를 모두 반환.
	public static List<Integer> naiveSearch(String H,String N) {		
		List<Integer> ret = new ArrayList<>();
		
		//모든 시작 위치를 다 시도해 본다.
		for(int begin=0; begin + N.length() <= H.length(); begin++) {
			boolean matched = true;
			for(int i=0; i<N.length();i++) {
				if(N.charAt(i) != H.charAt(begin+i)) {
					matched = false;
					break;
				}				
			}
			if(matched)
				ret.add(begin);			
		}
		return ret;
		/*
		 * 시작 위치 수 : O(|H|) // 각 비교 O(|N|)
		 * ==> O(|H|x|N|)
		 */
	}
	
	

}
