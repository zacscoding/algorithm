package chap20.string.suffixarray.p9248;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 not yet clear
 https://www.acmicpc.net/problem/9248
 */
public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		Integer[] suffix = new Suffix().getSuffixArray(str);
		for(int i=0;i<suffix.length;i++) {		
			System.out.print((suffix[i]+1)+" ");
		}
		System.out.print("\nx ");
		for(int i=1;i<suffix.length;i++) {
			System.out.print(commonPrefix(str,suffix[i-1],suffix[i])+" ");
		}
		
		sc.close();		
	}
	
	public static int commonPrefix(String s,int i,int j) {
		int k = 0;
		int size = s.length();
		while( i<size && j<size && (s.charAt(i) == s.charAt(j)) ) {
			i++; j++; k++;
		}
		return k;
	}

	
	public static class Suffix implements Comparator<Integer> {
		int t;
		int[] group;
		public Integer[] getSuffixArray(String s) {
			int n = s.length();		
			int temp = this.t = 1;
			group = new int[n+1];
			for(int i=0;i<n;i++) { //idx==0인 글자를 기준으로 그룹 나눔
				group[i] = s.charAt(i);
			}		
			group[n] = -1;		
			Integer[] perm = new Integer[n];		
			for(int i=0;i<perm.length;i++) {
				perm[i] = i;
			}
			
			
			while(t < n) {
				Arrays.sort(perm,this);			
				temp *=2;
				if(temp>=n)
					break;
				
				int[] newGroup = new int[n+1];
				newGroup[n] = -1;
				newGroup[perm[0]] = 0;
				
				for(int i=1;i<n;i++) {
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
		
		@Override
		public int compare(Integer a, Integer b) {		
			if(group[a] != group[b])
				return group[a] - group[b];
			return group[a+t] - group[b+t];		
		}
		
	}
}
