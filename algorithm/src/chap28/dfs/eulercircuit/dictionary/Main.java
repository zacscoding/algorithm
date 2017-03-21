package chap28.dfs.eulercircuit.dictionary;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * not complete
 */
public class Main {
	public static boolean[] seen;
	public static int[][] adj = new int[26][]; // 간선(i,j)는 알파벳 i가 j보다 앞에 와야 함을 나타낸다.
	public static List<Integer> order = new ArrayList<>(26);
	public static List<String> words; //입력 단어들
	public static int n; //입력 단어 개수	
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		long start = System.currentTimeMillis();
		//Scanner sc = new Scanner(System.in);
		int TC=sc.nextInt();		
		for(int test_case=0;test_case<TC;++test_case) {
			//문제
			n = sc.nextInt();
			words = new ArrayList<>(n);
			for(int i=0;i<n;i++) {
				words.add(sc.next());
			}
			makeGraph(words);			
			//정답
			List<Integer> result = topologicalSort();
			
			for(int i=0;i<result.size();i++) {
				System.out.print((char)(result.get(i)+'a')+" ");
			}
			
			System.out.println();
			
//			if(result ==null || result.isEmpty()) {
//				System.out.println("INVALID HYPOTHESIS");
//			} else {
//				
//			}
				
		}
		long end = System.currentTimeMillis();
		System.out.println("경과시간 : "+(end-start)+"ms");				
		sc.close();
	}	
		
	//주어진 단어들로부터 알파벳 간의 선후관계 그래프를 생성한다.
	public static void makeGraph(List<String> words) {		
		for(int i=0;i<adj.length;i++) {
			adj[i] = new int[26];
		}		
		for(int j=1 ; j< words.size() ; j++) {			
			int i=j-1;
			String w1 = words.get(i);
			String w2 = words.get(j);			
			int len = (w1.length() > w2.length()) ? w2.length() : w1.length();
			
			//word[i]가 word[j]앞에오는 이유를 찾는다
			for(int k=0;k<len;k++) {
				if(w1.charAt(k)!= w2.charAt(k)) {
					adj[w1.charAt(k)-'a'][w2.charAt(k)-'a'] = 1;
				}
			}
			//A,B,C가 있을 때 A-B , A-C , B-C다 비교 안하고 A-B,B-C만 하는 이유 :
			/* e.g) A = improper, C=impossible
			 * => r 이 o보다 앞에 나오는 것 알 수 있음
			 * => B가 두 단어의 가운데 오려면 B의 첫 세글자는 항상 imp (otherwise A앞 또는 C 뒤)
			 * => B는 impr or impo
			 * => 1) impr
			 * =>    B-C를 검사하면서, r이 o보다 앞에 있음
			 * => 2) impo
			 * =>    A-B를 검사하면서 r이 o보다 앞에 있음
			 * => 3) B의 네 번째 글자(t)가 r과 o사이에 오는 경우
			 * =>	 r은 t보다 앞섬 & t는 o보다 앞섬 => r이 o보다 앞섬 
			
			 */
		}		
	}
	
	
		
	//adj에 주어진 그래프를 위상정렬한 결과를 반환
	//그래프가 DAG가 아니라면 빈 벡터를 반환
	public static List<Integer> topologicalSort() {
		int n = adj.length;
		seen = new boolean[n];
		order.clear();		
		for(int i=0;i<n;i++) {
			if(!seen[i])
				dfs(i);			
		}
		
		//c++의 reverse...
//		order.add(order.get(order.size()-1));		
//		order.add(order.remove(1));
		
		//System.out.println("정렬 순서 : "+order);		
		//만약 그래프가 DAG가 아니라면 정렬 결과에 역방향 간선이 있다
//		for(int i=0;i<n;i++) {
//			for(int j=i+1;j<n;j++) {
//				if(adj[order.get(j)][order.get(i)]!=0) {					
//					return new ArrayList<>();
//				}
//			}
//		}
		
		//없는 경우라면 깊이 우선 탐색에서 얻은 순서를 반환
		return order;
	}
	

	public static void dfs(int here) {
		seen[here] = true; //here 방문 처리
		for(int there = 0; there < adj.length;there ++) {
			if(adj[here][there]==1 && !seen[there]) //here -> there 간선 존재 && there 방문X -> 재귀
				dfs(there);
		}
		order.add(here);
	}
	
	
	
	
	
	
	
	
}


/* input.txt
3
3
ba
aa
ab
5
gg
kia
lotte
lg
hanhwa
6
dictionary
english
is
ordered
ordinary
this
 */

/*output
INVALID HYPOTHESIS
ogklhabcdefijmnpqrstuvwxyz
abcdefghijklmnopqrstuvwxyz
 */




































































