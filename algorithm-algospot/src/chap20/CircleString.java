package chap20;

import java.util.Arrays;
import java.util.Comparator;

public class CircleString {	
	public static void main(String[] args) {
		String str = minShift("aavadakedavr");
		System.out.println(str);
	}
	
	public static String minShift(String s) {
		String s2 = s+s;
		Suffix2 suffix = new Suffix2();		
		Integer[] a = suffix.getSuffixArray(s2);		
		for(int i=0;i<a.length;i++) {
			if(a[i] <= s.length()) {
				return s2.substring(a[i],a[i]+s.length());
			}			
		}		
		//여기로 올 일읎 없어야 한다
		return "__oops__";
	}	
}

class Suffix2 implements Comparator<Integer> {
	/*
	public static void main(String[] args) {
		String str = "alohomora";
		Suffix suffix = new Suffix();		
		Integer[] suffixArray = suffix.getSuffixArray(str);		
		for(int i=0;i<suffixArray.length;i++) {
			System.out.print(suffixArray[i]+" ");
		}		
	}*/
	
	int t;
	int[] group;
	public Integer[] getSuffixArray(String s) {
		int n = s.length();		
		//group[i]=접미사들을 첫 t글자를 기준으로 정렬 했을 떄, S[i..]가 들어가는 그룹 번호
		// t=1 일 때는 정렬할 것 없이 S[i..]의 첫 글자로 그룹 번호를 정해 줘도 같은 효과가 있다.
		int temp = this.t = 1;
		group = new int[n+1];
		for(int i=0;i<n;i++) {
			group[i] = s.charAt(i);
		}		
		group[n] = -1;		
		//결과적으로 접미사 배열이 될 반환 값. 이 배열읠 lg(n)번 정렬
		Integer[] perm = new Integer[n];		
		for(int i=0;i<perm.length;i++) {
			perm[i] = i;
		}
		
		while(t < n) {
			//group[]은 첫 t글자를 기준으로 계산해 뒀다.
			//첫 2t글자를 기준으로 perm을 다시 정렬
			Arrays.sort(perm,this);			
			//2t글자가 n을 넘는다면 이제 접미사 배열 완성.
			temp *=2;
			if(temp>=n)
				break;
			
			//2t글자를 기준으로 한 그룹 정보를 만든다
			int[] newGroup = new int[n+1];
			newGroup[n] = -1;
			newGroup[perm[0]] = 0;
			
			for(int i=1;i<n;i++) {
				if(compare(perm[i-1],perm[i])<0)
					newGroup[perm[i]] = newGroup[perm[i-1]]+1;
				else
					newGroup[perm[i]] = newGroup[perm[i-1]];				
			}
			group = newGroup;
			this.t = temp;
		}		
		return perm;		
	}
	
	// 각 접미사들의 첫 t글자를 기준으로 한 그룹 번호가 주어질 때,
	// 주어진 두 접미사를 첫 2*t 글자를 기준으로 비교한다.
	// group[]은 길이가 0인 접미사도 포함한다.
	@Override
	public int compare(Integer a, Integer b) {		
		//첫 t글자가 다르면 이들을 이용해서 비교
		if(group[a] != group[b])
			return group[a] - group[b];
		//아니라면 S[a+t..]와 S[b+t..]의 첫 t글자를 비교		
		return group[a+t] - group[b+t];		
	}
	
}
