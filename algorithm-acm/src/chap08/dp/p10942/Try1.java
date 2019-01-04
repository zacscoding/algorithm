package chap08.dp.p10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10942
 */
public class Try1 {

    /*
7
1 2 1 3 1 2 1
4
1 3
2 5
3 3
5 7
     */
    static int[] a = new int[2001];
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        N = Reader.nextInt();

        for (int i = 1; i <= N; i++) {
            a[i] = Reader.nextInt();
        }

        M = Reader.nextInt();
        for (int i = 1; i <= M; i++) {
            System.out.println(isPalindrome(Reader.nextInt(), Reader.nextInt()));
        }
    }


    static String isPalindrome(int s, int e) {
        int size = (int) Math.ceil(e - s + 1);

        for (int i = 0; i < size; i++) {
            if (a[s + i] != a[e - i]) {
                return "0";
            }
        }

        return "1";
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
    }

}
