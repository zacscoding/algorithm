package chap25.disjointset;

import java.util.ArrayList;
import java.util.List;

class NaiveDisjointSet {
	List<Integer> parent;
	
	NaiveDisjointSet(int n) {
		parent = new ArrayList<>(n);
		for(int i=0; i<n ;i++) {
			parent.add(i);
		}
	}
	
	// u가 속한 트리의 루트의 번호를 반환
	public int find(int u) {
		if(u == parent.get(u))
			return u;
		return find(parent.get(u));
	}
	
	// u가 속한 트리와 v가 속한 트리를 합친다.
	public void union(int u,int v) {
		u = find(u);
		v = find(v);
		
		// u와 v가 이미 같은 트리에 속한 경우는 걸러냄
		if(u == v) return;
		parent.set(u, v);
	}
}


class OptimizedDisjointSet {
	List<Integer> parent;
	List<Integer> rank;
	
	OptimizedDisjointSet(int n) {
		parent = new ArrayList<>(n);
		rank = new ArrayList<>(n);
		for(int i=0; i<n ;i++) {
			rank.add(1);
			parent.add(i);
		}
	}
	
	// u가 속한 트리의 루트의 번호를 반환
	// 압축 최적화, find(u)를 호출하면, u에서 루트까지 올라가는
	// 경로 상에 있는 모든 노드들에도 경로 압축 최적화가 자동으로 수행
	public int find(int u) {
		if(u == parent.get(u)) 
			return u;
		
		int ret = parent.set(u, find(parent.get(u)));
		return ret;
	}
	
	// u가 속한 트리와 v가 속한 트리를 합친다.
	public void union(int u,int v) {
		u = find(u);
		v = find(v);
		
		// u와 v가 이미 같은 집합에 속하는 경우를 걸러낸다.
		if(u == v)
			return;
		if(rank.get(u) > rank.get(v)) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		// rank[v]가 항상 rank[u] 이상이므로 u를 v의 자식으로 넣는다.
		parent.set(u, v);
		if(rank.get(u) == rank.get(v)) 
			rank.set(v,rank.get(v)+1);
		
	}	
}


public class Main {
	
	
	

}
