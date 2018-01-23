package chap20.string.suffixarray.p11478;

/*
 
 Clear
 https://www.acmicpc.net/problem/11478
 
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);		
		String str = sc.next();		
		System.out.println(constSubstrings(str));
	}
	
	public static int commonPrefix(String s,int i,int j) {
		int k = 0;
		int size = s.length();
		while( i<size && j<size && (s.charAt(i) == s.charAt(j)) ) {
			i++; j++; k++;
		}
		return k;
	}
	
	public static int constSubstrings(String s) {
		Integer[] a = new Suffix().getSuffixArray(s);
		int n = s.length();		
		int ret = n - a[0];		
		for(int i=1; i<a.length;i++) {
			int cp = commonPrefix(s,a[i-1],a[i]);
			ret += (n - a[i] - cp);
		}
		return ret;
	}
	
	
	
	public static class Suffix implements Comparator<Integer> {		
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
					//이전 perm[i]의 그룹 번호와 비교
					if(compare(perm[i-1],perm[i])<0) //다르면
						newGroup[perm[i]] = newGroup[perm[i-1]]+1;
					else //같으면
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
	
}