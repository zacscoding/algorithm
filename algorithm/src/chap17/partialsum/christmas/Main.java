package chap17.partialsum.christmas;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int K;
	public static int[] psum;	
	public static int[] modpsum;
	public static final int MOD = 20091101;
	
	public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	/**		input		*/
        	N = sc.nextInt();
        	K = sc.nextInt();
        	modpsum = new int[N+1];
        	psum = new int[N+1];
        	        	
        	modpsum[0] = psum[0] = 0; 
        	
        	for(int i=1; i<=N; i++) {
        		int cur = sc.nextInt();
        		psum[i] = psum[i-1] + cur;
        		modpsum[i] = psum[i] % K;
        	}
        	
        	/**		output		*/
        	System.out.println(waysToBuy()+" "+maxBuys());
        }
        sc.close();
    }
	
	
	public static int waysToBuy() {
		long ret = 0;
		//modpsum[]의 각 값을 몇번이나 본적 있는지 기록 
		long[] count = new long[K];		
		for(int i=0;i<modpsum.length;i++) {
			count[modpsum[i]]++;
		}
		
		//두 번 이상 본 적 있다면 이 값 중 두 개를 선택하는 방법의 수를 더한다.
		for(int i=0;i<K;i++) {
			if(count[i] >= 2)
				ret = (ret + (count[i]*(count[i]-1) /2)) % MOD;
		}
		return (int)ret;
	}
		
	//0번 상자부터 i번 상자까지의 범위 내에서 서로 겹치지 않고 구매할 수 있는 부분 구간의 최대 수
	public static int maxBuys() {		
		// ret[i] = 첫 번째 상자부터 i 번째 상자까지 고려했을 때 살 수 있는 최대 개수
		int[] ret = new int[N+1];
		// prev[s] = modpsum[]이 s였던 마지막 위치
		int[] prev = new int[K];
		
		for(int i=0; i<=N; i++) {
			//i번째 상자를 아예 고려하지 않는 경우
			if(i>0)
				ret[i] = ret[i-1];
			else
				ret[i] = 0;
			// modpsum[i]를 전에도 본 적이 있으면, prev[psum[i]]+1 부터 여기까지 쭉 사기
			int loc = prev[modpsum[i]]; //가장 마지막 상자 선택
			if(loc != 0)
				ret[i] = Math.max(ret[i],ret[loc]+1);
			// prev[]에 현재 위치 기록
			prev[modpsum[i]] = i;
		}		
		return ret[N];		
	}
}

 


/* input.txt
2
6 4
1 2 3 4 5 6
4 1
1 2 3 4
*/

/* output.txt
3 1
*/

































