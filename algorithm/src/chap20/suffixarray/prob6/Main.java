package chap20.suffixarray.prob6;

import java.util.Arrays;
import java.util.Comparator;

/*
not yet clear
https://www.acmicpc.net/problem/5582
 */
public class Main {
	static char[] s1;
	static char[] s2;
	
	public static void main(String[] args) {
		String [] sArr = {
				"ABRACADABRA",
				"ECADADABRBCRDARA"
		};
		
		
		for(int j=0;j<sArr.length;j++) {
			System.out.println("------------------------");
			String s = sArr[j];
			Integer[] suff = Suffix.inst.getSuffix(s.toCharArray());
			for(int i=0;i<s.length();i++) {
				System.out.println(s.substring(suff[i]));
			}			
			System.out.println("------------------------");
		}
		
	}

	public static class Suffix implements Comparator<Integer> {
		private Suffix(){}		
		public static Suffix inst;
		static{
			inst = new Suffix();
		}
		
		
		int[] group;
		int t;
		
		public Integer[] getSuffix(char[] s) {
			int n = s.length;
			int temp = t = 1;
			group = new int[n+1];
			Integer[] perm = new Integer[n];			
			for(int i=0;i<n;i++) {
				group[i] = s[i];
				perm[i] = i;
			}
			group[n] = -1;
			
			while(t < n) {
				Arrays.sort(perm,this);
				
				temp *= 2;
				if(temp >= n)
					break;
				
				int[] newGroup = new int[n+1];
				newGroup[n] = -1;
				newGroup[perm[0]] = 0;
				
				for(int i=1;i<n;i++) {
					if(compare(perm[i-1],perm[i]) < 0)
						newGroup[perm[i]] = newGroup[perm[i-1]]+1;
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
				return group[a] - group[b];
			return group[a+t] - group[b+t];			
		}		
	}
	
	
}
