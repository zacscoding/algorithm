package chap20.string.suffixarray.p1701;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Clear
https://www.acmicpc.net/problem/1701
 */
public class Main {	
	public static char[] str;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		str = sc.next().toCharArray();
		Integer[] suffix = Suffix.getInstance().getSuffixArray(str);
		int result = 0;
		for(int i=0;i<str.length-1;i++) {
			result = Math.max(result,commonSuffix(suffix[i],suffix[i+1]));
		}	
		System.out.println(result);
	}	
	
	public static int commonSuffix(int i,int j) {
		int size = str.length;
		int ret = 0;
		
		while(i<size && j<size && str[i] == str[j]) {
			i++;j++;ret++;
		}
		return ret;
	}
	
	public static class Suffix implements Comparator<Integer> {
		private static Suffix inst = new Suffix();
		private Suffix() {}
		public static Suffix getInstance() {
			return inst;
		}
		
		int t;
		int[] group;
		public Integer[] getSuffixArray(char[] s) {			
			int size = s.length;	
			int temp = t = 1;
			group = new int[size+1];
			Integer[] perm = new Integer[size];
			for(int i=0;i<size;i++) {
				group[i] = s[i];
				perm[i] = i;
			}
			group[size] = -1;	
			
			while(t < size) {
				Arrays.sort(perm,this);				
				temp = 2*t;
				if(temp >= size)
					break;
				int[] newGroup = new int[size+1];
				newGroup[size] = -1;
				newGroup[perm[0]]=0;
				
				for(int i=1;i<size;i++) {
					if(compare(perm[i-1],perm[i])<0)
						newGroup[perm[i]] = newGroup[perm[i-1]]+1; //새로운 그룹 번호 부여
					else
						newGroup[perm[i]] = newGroup[perm[i-1]];
						
				}
				
				group = newGroup;
				t = temp;
			}
			return perm;
		}		

		@Override
		public int compare(Integer a, Integer b) {
			if(group[a] != group[b])
				return group[a]-group[b];
			return group[a+t]-group[b+t];			
		}
		
	}
	
	
}
