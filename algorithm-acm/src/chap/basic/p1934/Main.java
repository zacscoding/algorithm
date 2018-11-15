package chap.basic.p1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1934
 *
 * @author zacconding
 * @Date 2018-11-15
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        int T = Reader.nextInt();

        while (T-- > 0) {
            int a = Reader.nextInt();
            int b = Reader.nextInt();

            int aa = Math.max(a, b);
            int bb = Math.min(a, b);

            int r = aa % bb;
            while (r != 0) {
                aa = bb;
                bb = r;
                r = aa % bb;
            }

            System.out.println(bb * (a / bb) * (b / bb));
        }
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