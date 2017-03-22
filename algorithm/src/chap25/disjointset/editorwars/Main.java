package chap25.disjointset.editorwars;

import java.io.*;
import java.util.*;

class BipartiteUnionFind {
	// parent[i] = i의 부모 노드, 루트라면 i
	// rank[i] = i가 루트인 경우, i를 루트로 하는 트리의 랭크
	// enemy[i] = i 가 루트인 경우, 해당 집합과 적대 관계인 집합의 루트의 번호(없으면 -1)
	// size[i] = i 가 루트인 경우 , 해당 집합의 크기	
	int[] parent;
	int[] rank;
	int[] enemy;
	int[] size;	
	int n;
	
	//init
	BipartiteUnionFind(int n) {
		this.n = n;
		parent = new int[n];
		rank = new int[n];
		enemy = new int[n];
		size = new int[n];		
		for(int i=0; i<n; i++) {
			parent[i] = i;
			enemy[i] = -1;
			size[n] = 1;
		}
	}
	
	public int find(int u) {
		if(parent[u] == u) return u;
		return parent[u] = find(parent[u]);
	}
	
	public int merge(int u,int v) {
		// u나 v가 공집합인 경우 나머지 하나를 반환
		if(u == -1 || v == -1) return Math.max(u, v);
		//부모 찾기
		u = find(u);
		v = find(v);
		
		//rank[u] <= rank[v] 유지
		if(rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		// 이제 항상 rank[v]가 더 크므로 u를 v의 자식으로 넣기
		if(rank[u] == rank[v]) 
			rank[v]++;
		parent[u] = v;
		size[v] += size[u];
		return v;
	}
	
	// u와 v가 서로 적. 모순이 일어났으면 false, 아니면 true 반환
	public boolean dis(int u,int v) {
		
		// 루트 찾기
		u = find(u);
		v = find(v);
		
		// 같은 집합에 속해 있으면 모순
		if(u == v)
			return false;
		
		//적의 적은 나의 같은 편
		int a = merge(u,enemy[v]);
		int b = merge(v,enemy[u]);
		enemy[a] = b;
		enemy[b] = a;		
		return true;
	}
	
	// u와 v가 서로 동지. 모순이 일어나면 false 아니면 true 반환
	public boolean ack(int u,int v) {
		
		//루트 찾기
		u = find(u);
		v = find(v);
		
		//두 집합이 서로 적대 관계면 모순
		if(enemy[u] == v)
			return false;
		
		//동지의 적은 나의 적
		int a = merge(u,v);
		int b = merge(enemy[u],enemy[v]);
		enemy[a] = b;
		
		//두 집합 다 적대하는 집합이 없으면 b는 -1일 수도 있음
		if(b != -1)
			enemy[b] = a;
		return true;		
	}	
	
	//BipartiteUnionFind 인스턴스가 주어질 때,
	// 한 파티에 올 가능성이 있는 최대 인원을 구한다.
	public static int maxParty(BipartiteUnionFind buf) {		
		int ret = 0;
		for(int node=0; node<buf.n; node++) {
			if(buf.parent[node] == node) {
				int enemy = buf.enemy[node];
				//같은 모임 쌍을 두 번 세지 않기 위해, enemy < node인 경우만 센다
				//enemy == -1 인 경우도 정확히 한 번씩 세개 된다.
				if(enemy > node)
					continue;
				int mySize = buf.size[node];
				int enemySize = (enemy == -1 ? 0 : buf.size[enemy]);
				
				//두 집합 중 큰 집합을 더한다.
				ret += Math.max(mySize,enemySize);
			}
		}
		return ret;
	}
	
}

public class Main {
	
	
	public static void main(String[] args) {
		
	}
	
	
	
	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;
		
		public static void init(InputStream input) throws Exception {			
			reader = new BufferedReader(new InputStreamReader(input));			
		}
		
		public static String readLine() throws Exception {
			return reader.readLine();
		}
		
		public static String next() throws Exception {
			while(tokenizer==null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}
		
		public static int nextInt() throws Exception {
			return Integer.parseInt( next() );
		}		
	}
}
