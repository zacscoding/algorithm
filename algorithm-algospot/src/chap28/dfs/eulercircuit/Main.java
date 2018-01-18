package chap28.dfs.eulercircuit;

import java.util.ArrayList;
import java.util.List;

public class Main {	
	public static int[][] adj;	
	public static void main(String[] args) {
		adj = new int[8][];
		for(int i=0;i<adj.length;i++) {
			adj[i] = new int[8];
		}		
		makeEdge('a','b');
		makeEdge('b','c');
		makeEdge('c','d');
		makeEdge('d','e');
		makeEdge('e','f');
		makeEdge('f','g');
		makeEdge('g','d');
		makeEdge('g','h');
		makeEdge('h','a');
		List<Integer> circuit = new ArrayList<>();
		getEulerCircuit(0, circuit);
		
		for(int i=0; i<circuit.size() ; i++) {
			System.out.print((char)(circuit.get(i)+'a')+" ");
		}
		
	}
	
	public static void makeEdge(char v1,char v2) {
		adj[(int)(v1-'a')][(int)(v2-'a')] = 1;
		adj[(int)(v2-'a')][(int)(v1-'a')] = 1;
	}
	
	//무향 그래프의 인접 행렬 adj가 주어질 때 오일러 서킷을 계산
	//결과로 얻어지는 circuit을 뒤집으면 오일러 서킷이 됨.
	public static void getEulerCircuit(int here, List<Integer> circuit) {
		for(int there = 0 ; there < adj.length; there ++) {
			while(adj[here][there] > 0) {
				adj[here][there]--; //양쪽 간선을 모두 지움
				adj[there][here]--;
				getEulerCircuit(there,circuit);
			}
		}
		//circuit.addFirst(here);
		circuit.add(here);
	}
}


/*
오일러 서킷 조건 

1) 무향 그래프


2) 방향 그래프
각 정점에 인접한 간선이 짝수 (들어온 횟수와 나간 횟수가 같아야 하기 때문에)



 */



















