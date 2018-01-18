package chap25.disjointset.editorwars;

import java.io.*;
import java.util.*;

public class Try1 {
	
	public static int[] parent;
	public static int[] rank;
	
	public static void main(String[] args) throws Exception {
		Reader.init(System.in);
		int cases = Reader.nextInt();		
		while(cases-- > 0) {
			//입력 및 초기화
			int N = Reader.nextInt();
			int M = Reader.nextInt();			
			parent = new int[N];
			rank = new int[N];
			for(int i=0;i<N;i++) {
				parent[i] = i;
				rank[i] = 1;
			}
			
			//모순 상태
			boolean isConstradiction = false;
			//모순 index
			int constradictionIdx = 0;
			
			for(int i=0;i<M;i++) {
				if(isConstradiction) { //모순 상태이면 입력만 완료하기
					Reader.readLine();
				} else {
					String state = Reader.next();
					int a = Reader.nextInt();
					int b = Reader.nextInt();
				
					if(state.equals("ACK")) { //같은 집합
						union(a,b);
					} else { //다른 집합
						if(parent[a] == parent[b]) { //부모가 같으면 모순
							constradictionIdx = i+1;
							isConstradiction = true;
						} 
					}					
				}								
			}
			if(isConstradiction) {
				System.out.println("모순 , "+constradictionIdx);
			} else {
				System.out.println("모순아님");
			}
		}		
	}	
	
	//u 루트 번호 찾기
	public static int find(int u) {
		if(u == parent[u])
			return u;
		return parent[u] = find(parent[u]);	
	}
	
	public static void union(int u,int v) {
		u = find(u);
		v = find(v);
		
		//이미 같은 집합
		if(u == v)
			return;
		
		//rank[u] < rank[v]유지
		if(rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		//u를 v의 자식으로
		parent[u] = v;
		
		//둘의 rank가 같으면 rank ++
		if(rank[u] == rank[v])
			rank[v]++; 
		
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

/*

input--

4                               
4 4
ACK 0 1
ACK 1 2
DIS 1 3
ACK 2 0
100 4
ACK 0 1
ACK 1 2
ACK 2 3
ACK 3 4
3 3
ACK 0 1
ACK 1 2
DIS 2 0
8 6
DIS 0 1
ACK 1 2
ACK 1 4
DIS 4 3
DIS 5 6
ACK 5 7




output--

MAX PARTY SIZE IS 3
MAX PARTY SIZE IS 100
CONTRADICTION AT 3
MAX PARTY SIZE IS 5 
 
 
 * */
