package chap28.dfs.wordchain;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSelf {
	public static int N;
	public static List<String> words;
	public static List<String> oddWords;
	public static boolean[] visited;
	public static int[][] adj;
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		long start = System.currentTimeMillis();
		//Scanner sc = new Scanner(System.in);
		int TC=sc.nextInt();		
		for(int test_case=0;test_case<TC;++test_case) {
			//문제
			N = sc.nextInt();
			adj = new int[N][];
			visited = new boolean[N];
			words = new ArrayList<>(N);
			for(int i=0;i<N;i++) {
				adj[i] = new int[N];
				words.add(sc.next());
			}
			System.out.println("test case"+test_case);
			//oddWords = new ArrayList<>(N);
			makeEdge();			
			for(int i=0;i<adj.length;i++) {
				System.out.print(words.get(i)+": ");
				for(int j=0;j<adj[i].length;j++) {
					if(adj[i][j]==1)
						System.out.print(words.get(j)+" ");
				}
				System.out.println();
			}
			System.out.println("----------------------------------");			
			//정답
		}
		long end = System.currentTimeMillis();
		System.out.println("경과시간 : "+(end-start)+"ms");				
		sc.close();
	}
	
	public static void makeEdge() {
		for(int i=0;i<N;i++) {
			String str = words.get(i);
			char last = str.charAt(str.length()-1);
			for(int j=0;j<N ;j++) {
				if(words.get(j).charAt(0)==last) {
					adj[i][j] = 1;
				}
			}			
		}		
	}
	
	public static void dfs(int here,List<Integer> order) {
		visited[here] = true;		
		order.add(here);		
		for(int there=0;there<N;there++) {
			if(!visited[there] && adj[here][there]==1) {
				adj[here][there] = 0;
				dfs(there,order);
				
			}
		}		
	}
	
	public static void dfsAll(List<Integer> order) {
		for(int i=0; i<N; i++) {
			if(!visited[i])
				dfs(i,order);
		}
	}
	
	public static boolean check() {
		for(int i=0;i<N;i++) {
			if(!visited[i])
				return false;
		}
		return true;
	}
	
	
	
	
}

/* input.txt
3
4
dog
god
dragon
need
3
aa
ab
bb
2
ab
cd
 */

/*
need dog god dragon
aa ab bb
IMPOSSIBLE
*/


/*
해밀토니안 경로(Hamiltonian path)
: 그래프의 모든 정점을 정확히 한번 씩 지나는 경로

=> 직관적으로 해밀토니안 경로로 접근 
=> 단어를 vertext, word1의 끝 알파벳 == word2의 첫 알파벳이면 간선 연결(방향그래프로)
=> 그러면 최악의 경우 모든 경로를 탐색해야함 n!이됨
=> 다른 접근이 필요.




 */





























