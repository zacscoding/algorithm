package test;

import java.io.*;
import java.util.*;

public class DefaultMain {
	static String str, reverse;
	static int[] pi;
	
	public static void main(String[] args) throws IOException {		
		Reader.init(System.in);
		int cases = Reader.nextInt();
		for(int ci=0; ci<cases; ci++){
			str = Reader.nextLine();			
			reverse = new StringBuilder(str).reverse().toString();			
		}		
	}
	
	
	/** Class for buffered reading int and double values */
	static class Reader {
	    static BufferedReader reader;
	    static StringTokenizer tokenizer;

	    /** call this method to initialize reader for InputStream */
	    static void init(InputStream input) {
	        reader = new BufferedReader(
	                     new InputStreamReader(input) );
	        tokenizer = new StringTokenizer("");
	    }

	    /** get next word */
	    static String next() throws IOException {
	        while ( ! tokenizer.hasMoreTokens() ) {
	            //TODO add check for eof if necessary
	            tokenizer = new StringTokenizer(
	                   reader.readLine() );
	        }
	        return tokenizer.nextToken();
	    }

	    /** get next line */
	    static String nextLine() throws IOException {
	        return reader.readLine();
	    }

	    static int nextInt() throws IOException {
	        return Integer.parseInt( next() );
	    }
	    static double nextDouble() throws IOException {
	        return Double.parseDouble( next() );
	    }
	}
}
