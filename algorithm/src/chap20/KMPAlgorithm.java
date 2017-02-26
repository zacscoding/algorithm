package chap20;

import java.util.ArrayList;
import java.util.List;

/*
 * KMP(Knuth-Morris-Pratt,   커누스-모리스-프랫)
 * 검색 과정에서 얻는 정보를 버리지 않고 잘 활용
 *  
 */
public class KMPAlgorithm {
	
	public static void main(String[] args) {		
		String H = "aabadaabacd";                                                                                                                                                                                                                                   
		String N = "aabaabac";		
		List<Integer> idxList = kmpSearch(H,N);
		for(int i=0;i<idxList.size(); i++) {
			System.out.println(idxList.get(i));
		}		
	}
	
	//'짚더미' H의 부분 문자열로 '바늘' N이 출현하는 시작 위치들을 모두 반환
	public static List<Integer> kmpSearch(String H, String N) {
		int n = H.length(), m = N.length();
		List<Integer> ret = new ArrayList<>(n-m+1); //max check : m-n+1 <--[0,m-n-1] 여유1
		
		// pi[i] = N[..i]의 접미사도 되고 접두사도 되는 문자열의 최대 길이		
		int[] pi = getPartialMatch(N);
		
		//begin = matched = 0 부터 시작
		int begin = 0, matched = 0;
		//String H = "aabadaabacd";
		//String N = "aaba";
		while(begin <= n-m) {
			//만약 짚더미의 해당 글자가 바늘의 해당 글자와 같으면
			if(matched < m && (H.charAt(begin + matched) == N.charAt(matched))) {
				matched ++;				
				//결과적으로 m글자가 모두 일치했다면 답에 추가
				if(matched == m)
					ret.add(begin);				
			} else {				
				//예외 : matched가 0인 경우에는 다음칸에서 계속.
				if(matched == 0) { // case1)처음부터 불일치
					begin++;
				} else {  // case2)일치하다가 불일치 
					begin += (matched - pi[matched-1]); //begin+1을 비교하는게 아니라, 다음 index부터 계산
					//begin을 옮겼다고 처음부터 다시 비교할 필요 없음.
					// 옮긴 후에도 pi[matched-1]만큼은 항상 일치함.					
					matched = pi[matched-1];					
				}
			}
		}		
		return ret;
	}
	
	public static List<Integer> kmpSearch2(String H,String N) {
		int n = H.length(), m = N.length();
		List<Integer> ret = new ArrayList<>();
		int[] pi = getPartialMatch(N);
		
		//현재 대응된 글자 수
		int matched = 0;
		//짚더미의 각 글자를 순회
		for(int i=0;i<n;i++) {
			//matched번 글자와 짚더미의 해당 글자가 불일치할 경우,
			//현재 대응된 글자의 수를 pi[matched-1]로 줄인다.
			while(matched>0 && H.charAt(i) != N.charAt(matched))
				matched = pi[matched-1];
			//글자가 대응될 경우
			if(H.charAt(i) == N.charAt(matched)) {
				matched ++;
				if(matched == m) {
					ret.add(i-m+1);
					matched = pi[matched-1];
				}
			}			
		}
		return ret;
	}
	
	
	/*
	 * 시간 복잡도
	 * if문 : begin+matched는 절대 감소X.(matched가 감소해도 begin은 ++됨)
	 * matched가 감소할 때도 begin은 항상 그 감소분만큼 증가 => 둘의 합 일정
	 * => 한번 matched가 증가하면, H[begin+matched]를 다시 참조할 일 X
	 * => 문자 비교 성공은 짚더미의 각 문자당 최대 한번씩만 일어날 수 있음 => 최대 O(|H|)
	 * 
	 * if문의 비교가 최대 몇 번 실패?
	 * begin은 0에서 시작해, 분기가 시행할 때마다 1이상씩 증가. 
	 * 전체 알고리즘은 begin이 |H|-|N|을 초과하면 곧장 종료 -> 이 분기는 최대 수행 횟수 : O(|H|)
	 * 
	 * ==> kmpSearch()는 N에 상관없이, 반복문의 전체 수행 횟수는 O(|H|)
	 */
	
	
	// N에서 자기 자신을 찾으면서 나타나는 부분 일치를 이용해 pi[]를 계산.
	// pi[i] = N[..i]의 접미사도 되고 접두사도 되는 문자열의 최대 길이
	public static int[] getPartialMatch(String N) {
		int m = N.length();
		int[] pi = new int[m];
		//단순한 문자열 검색 알고리즘을 구현.
		for(int begin = 1; begin < m; begin++) {
			for(int i=0; i+begin < m; i++) {
				if(N.charAt(begin + i) != N.charAt(i))
					break;
				//i+1 글자가 서로 대응
				pi[begin + i] = Math.max(pi[begin+i],i+1); //현재보다 왼쪽에 있는 시작 위치에서 이 위치에 값을 갱신했을지도 모르므로															
			}
		}
		return pi;
	}
	
	// KMP 알고리즘 이용
	// N에서 자기 자신을 찾으면서 나타나는 부분 일치를 이용해 pi[]를 계산
	// pi[i]=N[..i]의 접미사도 되고 접두사도 되는 문자열의 최대 길이
	public static int[] getPartialMatch2(String N) {
		int m = N.length();
		int[] pi = new int[m];
		
		//KMP로 자기 자신을 찾는다.
		//N을 N에서 찾는다. begin=0이면 자기 자신을 찾아버리니까 안됨
		int begin = 1, matched = 0;
		//비교할 문자가 N의 끝에 도달할 때까지 찾으면서 부분 일치를 모두 기록한다.
		while(begin+matched < m) {
			if(N.charAt(begin+matched) == N.charAt(matched)) {
				matched ++;
				pi[begin + matched -1] = matched;
			} else {
				if(matched == 0) {
					begin ++;					
				} else {
					begin += (matched - pi[matched-1]);
					matched = pi[matched -1];
				}	
			}			
		}
		return pi;
	}
}



















