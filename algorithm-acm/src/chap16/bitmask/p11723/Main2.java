package chap16.bitmask.p11723;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11723
 */
public class Main2 {

    static boolean[] a = new boolean[21];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int M = Reader.nextInt();
        StringBuilder answer = new StringBuilder(M * 2);

        while (M-- > 0) {
            String cmd = Reader.next();
            switch (cmd) {
                case "add":
                    a[Reader.nextInt()] = true;
                    break;
                case "remove":
                    a[Reader.nextInt()] = false;
                    break;
                case "check":
                    if (a[Reader.nextInt()]) {
                        answer.append(1).append("\n");
                    } else {
                        answer.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    int x = Reader.nextInt();
                    a[x] = a[x] ? false : true;
                    break;
                case "all":
                    for (int i = 1; i < a.length; i++) {
                        a[i] = true;
                    }
                    break;
                case "empty":
                    a = new boolean[21];
                    break;
            }
        }
        System.out.println(answer);
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
