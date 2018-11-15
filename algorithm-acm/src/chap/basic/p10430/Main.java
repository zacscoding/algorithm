package chap.basic.p10430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10430
 *
 * @author zacconding
 * @Date 2018-11-15
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        int A = Reader.nextInt();
        int B = Reader.nextInt();
        int C = Reader.nextInt();

        int first = (A + B) % C;
        int last = (A * B) % C;
        System.out.println(first);
        System.out.println(first);
        System.out.println(last);
        System.out.println(last);
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
