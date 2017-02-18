package test;

public class Main {	
	public static void main(String[] args) {
		int prev = 1983;
		final int MOD = (int)Math.pow(2,32);
		
		for(int i=1;i<=5;i++) {
			System.out.println(prev);
			prev = (prev*214013+25310111)%(MOD);
		}
	}

}
