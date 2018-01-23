package chap08.dp.sample;

import util.PrintUtil;

public class Fibonacci {
    private static int[] dp = new int[11];
    private static int[] dp2 = new int[11];
    private static int[] dp3 = new int[11];
    
    public static void main(String[] args) {
        for(int i=0;i <=10; i++) {
            PrintUtil.println("## [n : {}]  default : {} , dp1 : {}, dp2 : {}, dp3 : {} && default == dp1 : {} && dp1 == dp2 : {}, dp2 == dp3 : {}", new Object[] {
                    i, fibonacciDefault(i), fibonacciByDp(i) , fibonacciByDpWithButtomUp(i), 
                    fibonacciDefault(i) == fibonacciByDp(i), fibonacciByDp2(i), fibonacciByDp(i) == fibonacciByDp2(i),  fibonacciByDp2(i) == fibonacciByDpWithButtomUp(i)
            });                        
        }
    }
    
    public static int fibonacciDefault(int n) {
        if(n<=1) {
            return n;
        }
        else {
            return fibonacciDefault(n-1) + fibonacciDefault(n-2);
        }
    }
    
    public static int fibonacciByDp(int n) {
        if(n<=1) {
            return n;
        }
        else {
            dp[n] = fibonacciByDp(n-1) + fibonacciByDp(n-2);
            return dp[n];
        }
    }
    
    // Top-down
    public static int fibonacciByDp2(int n) {
        if(n<=1) {
            return n;
        }
        else {
            if(dp2[n] > 0) {
                return dp2[n];
            }            
            dp2[n] = fibonacciByDp(n-1) + fibonacciByDp(n-2);
            return dp2[n];
        }
    }
    
    //Buttom-up
    public static int fibonacciByDpWithButtomUp(int n) {
        dp3[0] = 1;
        dp3[1] = 1;
        for(int i=2; i<=n; i++) {
            dp3[i] = dp[i-1] + dp[i-2];
        }
        
        return dp3[n];
    }
    
}
