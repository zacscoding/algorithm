package chap25.disjointset.p2843;

/*

https://www.acmicpc.net/problem/2843

*/
import java.io.*;
import java.util.*;

public class Try3 {	
	public static int N;
	public static int[] adj;
	public static Map<Integer,List<Integer>> childMap;
	public static int[] visited;
	public static int[] dest;
	public static int checked = 0;
	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		
		N = Reader.nextInt();
		adj = new int[N+1];
		dest = new int[N+1];
		visited = new int[N+1];
		childMap = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			adj[i] = Reader.nextInt();
			List<Integer> childList = childMap.get(adj[i]);
			if(childList == null) {
				childList = new LinkedList<>();
				childMap.put(adj[i],childList);
			}
			childList.add(i);
		}
		
		int Q = Reader.nextInt();
		
		for(int i=0; i<Q; i++) {
			int comm = Reader.nextInt();
			int idx = Reader.nextInt();
			
			if(comm == 1) {
				checked++;
				int dest = find(idx);
				if(dest == -1) {
					System.out.println("CIKLUS");
				} else {
					System.out.println(dest);
				}
			} else {
				childMap.remove(adj[idx]);
				dest[idx] = adj[idx] = idx;				
				erase(idx,idx);
			}
		}
	}
	
	//check cycle(-1)
	//아니면 dest 반환
	public static int find(int u) {
		if(dest[u] != 0)
			return dest[u];
		//cycle
		if(visited[u] == checked) {
			return dest[u] = -1;
		}	
		
		//기저 간선이 없는 경우
		if(adj[u] == u)
			return dest[u] = u;
		
		visited[u] = checked;
		
		return dest[u] = find(adj[u]);
	}
	
	public static void erase(int u,int destVal) {
		List<Integer> list = childMap.get(u);
		if(list == null || list.isEmpty())
			return;
		
		for(int i=0;i<list.size();i++) {
			int child = list.get(i);
			dest[child] = destVal;
			erase(child,destVal);
		}
	}
	

	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;		
		
		public static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
		}
		
		
		public static String nextLine() throws IOException {
			return reader.readLine();
		}
		
		public static String next() throws IOException {
			while(tokenizer ==null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();			
		}
		
		public static int nextInt() throws IOException {
			return Integer.parseInt( next() );
		}				
	}
}
