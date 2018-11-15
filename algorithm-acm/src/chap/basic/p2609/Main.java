package chap.basic.p2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2609
 *
 * @author zacconding
 * @Date 2018-11-15
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        int a = Reader.nextInt();
        int b = Reader.nextInt();

        int g = gcd(Math.max(a, b), Math.min(a, b));
        int l = g * (a / g) * (b / g);
        System.out.println(g);
        System.out.println(l);
    }

    public static int gcd(int a, int b) {
        int r = a % b;

        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }

        return b;
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
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public static void close() throws IOException {
            if (reader != null) {
                reader.close();
            }
        }

    }
}