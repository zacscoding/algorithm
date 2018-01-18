package chap17.partialsum.maxsum;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
        	      	
        }
        sc.close();
    }
}


/*
input
2
4
1 2 3 4
3
-1 0 1

output
10
1

*/