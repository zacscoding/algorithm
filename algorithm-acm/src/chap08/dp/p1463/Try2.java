package chap08.dp.p1463;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1463
 *
 * @author zaccoding
 * github : https://github.com/zacscoding
 * @Date : 2018-01-19
 */
public class Try2 {
    public static int[] dp = new int[1000000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int input = scanner.nextInt();
        if(input == 1) {
            System.out.println(1);
        }
        else {
            stack.push(1);

            while(stack.isEmpty()) {

            }
        }
    }

//    public static int solve(int target, int opCnt, Stack<Integer> stack) {
//        int currentOpCnt = opCnt + 1;
//        while(stack.isEmpty()) {
//            int value = stack.pop();
//            if(dp[value+1] != 0) {
//                dp[value+1] = currentOpCnt;
//                return currentOpCnt;
//            }
//            if(dp[value*2] != 0) {
//
//            }
//
//            if(dp[value+1] ==0) {
//
//            }
//        }
//    }
}
