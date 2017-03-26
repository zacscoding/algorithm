package chap25.disjointset.p2843;

/*

https://www.acmicpc.net/problem/2843

*/


import java.io.*;
import java.util.*;

class Pair {
	int first,second;
	Pair(int a,int b) {
		this.first = a;
		this.second = b;
	}
}

public class Main {	
	public static int n,q,a,b,f;
	public static int[] par = new int[300010]; //부모노드
	public static int[] arr = new int[300010]; //adj
	public static boolean[] out = new boolean[300010];
	public static boolean[] cycle = new boolean[300010];
	public static Pair[] query = new Pair[300300];
	public static Stack<Integer> ans = new Stack<>();
	
	public static void main(String[] args) throws Exception {		
		Reader.init(System.in);
		n = Reader.nextInt();
		
		for (int i = 1; i <= n; i++)
			par[i] = i;
		
		for (int i = 1; i <= n; i++)
			arr[i] = Reader.nextInt();
		
		q = Reader.nextInt();
		
		for(int i = q-1; i>=0; i--) {
			a = Reader.nextInt();
			b = Reader.nextInt();
			query[i] = new Pair(a,b);
			if(a == 2)
				out[b] = true; //간선 삭제 예정인 것들 true
		}
		
		//루트라서 유니온 하지 않음?
		for (int i = 1; i <= n; i++) {
			if (!out[i]) {
				if (arr[i] != 0)
					merge(i, arr[i]);
			}
		}
		
		for (int i = 0; i < q; i++) {
			Pair x = query[i];
			if(x.first == 2) {
				merge(x.second, arr[x.second]);
				out[x.second] = false;
			} else {
				if(cycle[find(x.second)])
					ans.push(-1);
				else
					ans.push(find(x.second));
			}
		}
		
		while(!ans.isEmpty()) {
			int x = ans.pop();
			if(x == -1)
				System.out.println("CIKLUS");
			else
				System.out.println(x);
		}
	}
	
	public static int find(int x) {
		if(par[x] == x)
			return x;
		return par[x] = find(par[x]);
	}
	
	public static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			cycle[x] = true;
			return;
		}
		par[x] = y;
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
