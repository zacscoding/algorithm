package chap22.binarytree.nerd2;

import java.io.*;
import java.util.*;

/*
Clear
https://algospot.com/judge/problem/read/NERD2

 */
public class Main {
	
	//현재 다른 점에 지배당하지 않는 점들의 목록을 저장
	static TreeMap<Integer,Integer> coords = new TreeMap<>();	
	public static void main(String[] args) throws Exception {
		Reader.init(new FileInputStream("input.txt"));
		//Reader.init(System.in);
		int cases = Reader.nextInt();
        while(cases-- > 0) {
        	coords.clear();
        	int N = Reader.nextInt();    
        	int result = 0;
        	for(int i=0;i<N;i++) {
        		result += registered(Reader.nextInt(),Reader.nextInt());
        	}
        	System.out.println(result);
        }        
        Reader.close();
	}
	
	
	// 새로운 점 (x,y)가 기존의 다른 점들에 지배 당하는지 확인
	// O(lgN)
	public static boolean isDominated(int x,int y) {
		//x보다 오른쪽에 있는 점 중 가장 왼쪽에 있는 점을 찾음.
		Integer rightX = coords.higherKey(x);		
		//그런점이 없으면 (x,y)는 지배 당하지 않음
		if(rightX == null) return false;				
		return y < (coords.get(rightX));
	}
	
	// 새로운 점(x,y)에 지배당하는 기존 점들을 삭제
	// 한 점은 최대 한 번만 지워지므로 지워지는 점의 개수는 다 합해봐야 N-1
	public static void removeDominated(int x,int  y) {
		Integer leftX = coords.lowerKey(x); //x가장 왼쪽 찾음		
		Integer next = leftX; //
		while(true) {
			 //next가 널이면 브레이크
			if(next==null) break;
			Integer leftY = coords.get(next); //왼쪽 Y값과 비교			
			if(leftY>y) { //왼쪽Y가 y보다 크면, 나머지들도 다 y보다 크므로 브레이크
				break;
			} else {				
				coords.remove(next);
				next = coords.lowerKey(x);
			}				
		}		
	}
	
	// 새 점(x,y)가 추가되었을 때, coords를 갱신 & 다른 점에 지배당하지 않는 점들의 개수를 반환
	/*
	 * isDominated() ==> O(lgN)
	 * removeDominated() ==> O(N) (한점은 최대 한 번만 지워지므로 많아야 N-1)
	 * ==> O(NlgN)
	 */
	public static int registered(int x,int y) {
		// (x,y)가 이미 지배당하는 경우 그냥 (x,y)를 버림.
		if(isDominated(x, y)) return coords.size();
		
		//기존 있던 점 중 (x,y)에 지배당하는 점들을 지운다.
		removeDominated(x,y);
		coords.put(x, y);
		return coords.size();
	}
	
	
	
	
	
	
	
	

	static class Reader {
		static BufferedReader reader;
		static StringTokenizer tokenizer;		
		
		public static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}
		
		
		public static String nextLine() throws IOException {
			return reader.readLine();
		}
		
		public static String next() throws IOException {
			while(!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();			
		}
		
		public static int nextInt() throws IOException {
			return Integer.parseInt( next() );
		}
		
		public static void close() throws IOException {
			if(reader != null)
				reader.close();
		}
		
	}
}



/*
 *input.txt 
2
4
72 50
57 67
74 55
64 60
5
1 5
2 4
3 3
4 2
5 1

output
8
15
 */