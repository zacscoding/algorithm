package chap20;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArrayAlgorithm {
	/*
	 * 시간 복잡도 분석
	 * sort()의 시간 복잡도 O(nlgn) (두 원소의 비교에 상수 시간일 경우)
	 * 두 문자열을 비교하는 데는 최대 두 문자열의 길이에 비례하는 시간 -> 한 번에 O(n)
	 * ==> O(n^2lgn) 
	 * 실제로는 모든 문자열을 비교할 것 없이, 첫 몇 글자만 비교해도 됨 BUT "aaa...aaaa"일 경우 모든 비교가 문자열 끝까지 이루어짐
	 * 
	 */
	
	public static void main(String[] args) {
		String str = "alohomora";
		Integer[] arr = getSuffixArrayNaive(str);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" : "+str.substring(arr[i]));
		}		
	}	
	
	public static Integer[] getSuffixArrayNaive(String s) {
		//접미사 시작 위치를 담은 배열을 만듬
		Integer[] perm2 = new Integer[s.length()];
		for(int i=0;i<perm2.length;i++) {
			perm2[i] = i;
		}		
		//접미사를 비교하는 비교자를 이용해 정렬		
		Arrays.sort(perm2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {				
				return s.substring(o1).compareTo(s.substring(o2));
			}			
		});
		return perm2;
	}	
}
















