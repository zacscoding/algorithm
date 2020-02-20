package chap.basic.greedy.p10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/10610
 */
public class Try1 {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        String n = Reader.next();
        char[] chars = n.toCharArray();
        Arrays.sort(chars);

        if (chars[0] != '0') {
            System.out.println("-1");
        } else {
            int sum = 0;

            for (char ch : chars) {
                sum += ch - '0';
            }

            if (sum % 3 == 0) {
                System.out.println(new StringBuilder(new String(chars)).reverse());
            } else {
                System.out.println("-1");
            }
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

        public static void close() {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
