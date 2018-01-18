package chap28.dfs.wordchain;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(new FileInputStream("input.txt"));
		long start = System.currentTimeMillis();
		//Scanner sc = new Scanner(System.in);
		int TC=sc.nextInt();		
		for(int test_case=0;test_case<TC;++test_case) {
			//문제
			N = sc.nextInt();
			graph = new List[26][];
			for(int i=0;i<graph.length;i++) {
				graph[i] = new List[26];	
				for(int j=0;j<graph[i].length;j++) {
					graph[i][j] = new ArrayList<String>();
				}
			}
			
			List<String> words = new ArrayList<>(N);
			for(int i=0;i<N;i++) {
				words.add(sc.next());
			}
			
			
			
			//정답			
			System.out.println(solve(words));
			
			
		}
		long end = System.currentTimeMillis();
		System.out.println("경과시간 : "+(end-start)+"ms");				
		sc.close();
	}
	
	public static int N;
	
	//그래프의 인접 행렬 표현
	public static int[][] adj;		
	
	//i로 시작해서 j로 끝나는 단어 목록
	public static List<String> [][] graph;
	
	//indegree.get(i) == i로 시작하는 단어의 수 
	//outdegree.get(i) == i로 끝나는 단어의 수 
	//=>경로의 시작점을 쉽게 찾아 내기 위해
	public static int[] indegree;
	public static int[] outdegree;
	
	
	public static void makeGraph(List<String> words) {
		//전역 변수 초기화
		adj = new int[26][];
		for(int i=0;i<26;i++) {
			//adj초기화
			adj[i] = new int[26];
			
			//graph 초기화
			for(int j=0;j<26;j++) {
				graph[i][j].clear();
			}
		}
		indegree = new int[26];
		outdegree = new int[26];
		
		//각 단어를 그래프에 추가
		for(int i=0;i<words.size();i++) {
			String str = words.get(i);
			int a = str.charAt(0)-'a';
			int b = str.charAt(str.length()-1)-'a';			
			graph[a][b].add(str);
			adj[a][b]++;  
			indegree[b]++;
			outdegree[a]++; 
		}		
	}
	
	
	//유향 그래프의 인접 행렬 adj가 주어질 때 오일러 서킷 혹은 트레일을 계산
	public static void getEulerCircuit(int here,List<Integer> circuit) {
		for(int there=0 ; there < adj.length ; there ++) {
			while(adj[here][there] > 0) {
				adj[here][there]--; //간선 지우기 (방향그래프이므로 양쪽 지울 필요X)
				getEulerCircuit(there,circuit);
			}			
		}	
		circuit.add(here);
	}
	
	
	//현재 그래프의 오일러 트레일이나 서킷을 반환
	public static List<Integer> getEulerTrailOrCircuit() {		
		List<Integer> circuit = new LinkedList<>();
		
		//우선 트레일을 찾아본다 : 시작점이 존재하는 경우
		for(int i=0;i<26;i++) {
			if(outdegree[i] == (indegree[i]+1)) { //나가는 간선이 하나 더 많은 경우
				getEulerCircuit(i,circuit);
				return circuit;
			}
		}
		
		//아니면 서킷이니, 간선에 인접한 아무 정점에서나 시작
		for(int i=0;i<26;i++) {
			if(outdegree[i]!=0) {
				getEulerCircuit(i,circuit);
				return circuit;
			}
		}
		
		//모두 실패한 경우 널 반환
		return null;
	}
	
	/*
	 * (in 방향그래프)
	 * 오일러 서킷 : 모든 정점에서 나가는 간선의 수와 들어오는 간선의 수가 같음
	 * 트레일 : 나가는 간선이 하나 많은 시작점 하나, 들어오는 간선이 하나 많은 끝점 하나
	 */
	
	//현재 그래프에 오일러 서킷/트레일 존재 여부를 확인
	public static boolean checkEuler() {
		//예비 시작점과 끝점의 수
		int plus1=0,minus1=0;
		
		for(int i=0;i<26;i++) {
			int delta = outdegree[i] - indegree[i];
			
			//모든 정점의 차수는 -1,1 or 0 이여야 함
			if(delta < -1 || delta > 1)
				return false;
			if(delta == 1) //나가는 간선이 많음 
				plus1 ++;  //시작점 ++
			else if(delta == -1) //들어오는 간선이 많음
				minus1 ++; //끝점 ++
		}
		
		//시작점과 끝점은 각 하나씩 있거나 하나도 없어야 한다.
		return ( (plus1 ==1 && minus1 ==1) || (plus1==0 && minus1==0) );		
	}
	
	public static String solve(List<String> words) {
		makeGraph(words);		
		//차수가 맞지 않으면 실패
		if(!checkEuler())
			return "IMPOSSIBLE";
		
		//오일러 서킷이나 경로를 찾아냄
		List<Integer> circuit = getEulerTrailOrCircuit();
		
		//모든 간선을 방문하지 못했으면 실패
		if(circuit == null || circuit.size() !=words.size()+1 )
			return "IMPOSSIBLE";
		
		//아닌 경우 방문 순서를 뒤집은 뒤 간선들을 모아 문자열로 만들어 반환
		//reverse하기
		int low = 0 , high = circuit.size() -1;		
		while( low< circuit.size() && high >=0 && low < high ) {			
			int lowVal = circuit.remove(low);
			int highVal = circuit.remove(high-1);			
			circuit.add(low,highVal);
			circuit.add(high,lowVal);			
			low++;
			high--;
		}
		String ret="";
		
		for(int i=1;i<circuit.size();i++) {
			int a = circuit.get(i-1);
			int b = circuit.get(i);
			if(ret.length() !=0 )
				ret+=" ";
			ret+=graph[a][b].remove(graph[a][b].size()-1);			
		}
		
		return ret;
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




















