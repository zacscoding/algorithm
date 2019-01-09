package chap16.bitmask.p11723;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11723
 */
public class Main {

    static int n = 0;
    static int M;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        M = Reader.nextInt();
        StringBuilder answer = new StringBuilder(M * 2);

        while (M-- > 0) {
            String cmd = Reader.next();
            switch (cmd.charAt(0)) {
                case 'a': // add all
                    if (cmd.charAt(1) == 'd') {
                        n |= (1 << (Reader.nextInt() - 1));
                    } else {
                        n = (1 << 20) - 1;
                    }
                    break;
                case 'r': // remove
                    n &= ~(1 << (Reader.nextInt() - 1));
                    break;
                case 'c': // check
                    if ((n & (1 << Reader.nextInt() - 1)) != 0) {
                        answer.append(1).append("\n");
                    } else {
                        answer.append(0).append("\n");
                    }
                    break;
                case 't': // toggle
                    n ^= (1 << (Reader.nextInt() - 1));
                    break;
                case 'e': // empty
                    n = 0;
                    break;
            }
        }

        System.out.println(answer);
    }

    public static void toggle(int x) {
        n ^= (1 << (x - 1));
    }

    public static void empty() {
        n = 0;
    }

    public static void all() {
        n = (1 << 20) - 1;
    }

    public static void add(int x) {
        n |= (1 << (x - 1));
    }

    public static void remove(int x) {
        n &= ~(1 << (x - 1));
    }

    public static boolean exist(int x) {
        return (n & (1 << x - 1)) != 0;
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