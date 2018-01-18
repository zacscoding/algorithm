package chap28.dfs;

import java.util.List;

public class Main {
	
	/**		LinkedList 기반		*/
	//그래프의 인접 리스트 표현
	public static List<List<Integer>> adj;
	
	//각 정점을 방문했는지 여부
	public static List<Boolean> visited;
	
	//깊이 우선 탐색
	public static void dfs(int here) {
		System.out.println("DFS visits : "+here);
		//모든 인접 정점을 순회하면서
		for(int i=0;i < adj.get(here).size(); i++) {
			int there = adj.get(here).get(i);			
			if(!visited.get(there)) 
				dfs(there);			
		}
		//더이상 방문할 정점이 없으니, 재귀 호출을 종료 & 이전 정점으로 돌아간다.		
	}
	
	//모든 정점을 방문한다.(dfs만 가지고는 모든 정점을 순서대로 발견한다는 보장X)
	public static void dfsAll() {
		//visited를 모두 false로 초기화(자바는 생략)
		
		//모든 정점을 순회하면서, 아직 방문한 적 없으면 방문
		for(int i=0 ;i<adj.size();i++) {
			if(!visited.get(i))
				dfs(i);
		}
	}	
	
	
	/**		인접 행렬 기반		*/
	//인접 행렬 표현
	public static boolean[] check;
	public static int[][] a;
	public static int n;
	
	public static void dfs2(int x) {
		check[x] = true;
		System.out.println(x);
		for(int i=1;i<=n;i++) {
			if(a[x][i] == 1 && !check[i]) 
				dfs(i);
		}
	}
	
}








/* 활용 예제

1) 두 정점이 서로 연결되어 있는지 확인 u1,u2
dfs(u1) -> u1에서부터 간선들을 통해 갈 수 있는 모든 정점 방문
-> visited[]를 참조

2)연결된 부분집합의 개수 세기 component {a,b,f,g} // {c,d,e,h} 라고 가정
-> dfs()를 호출하면 같은 컴포넌트에 속한 점은 모조리 방문
-> dfsAll()에서 dfs()를 호출하는 횟수를 세면 그래프가 몇 개의 컴포넌트로 나뉘어 있는지 확인 가능

3)위상 정렬
1.김치를 다진 마늘과 볶는다.
2. 볶은 김치에 돼지고기 넣고 더 볶는다.
.....
=> 작업 B를 하기 전에 반드시 작업 A를 해야한다 -> 작업 B가 작업A에 의존한다.
=> 각 작업을 정점으로 표현 & 작업 간의 의존 관계를 간선으로 표현 == 의존성 그래프(dependency graph)
=> 의존성 그래프 위상 정렬 하는 법
1)들어오는 간선이 하나도 없는 정점들을 하나씩 찾아서 정렬 결과의 뒤에 붙이고, 그래프에서 이 정점을 지우는 과정 반복
2)dfsAll()을 수행하며 dfs()가 종료할 때마다 현재 정점의 번호를 기록 & dfsAll()종료 후 기록된 순서 뒤집기

 
 
 
 */


