package chap25.disjointset.p1976;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1976
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int m = Reader.nextInt();

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int e = Reader.nextInt();
                if (e == 1) {
                    unionParent(parent, i + 1, j + 1);
                }
            }
        }

        boolean b = true;
        int p = 0;

        for (int i = 0; i < m; i++) {
            int v = Reader.nextInt();

            if (b) {
                if (i == 0) {
                    p = getParent(parent, v);
                } else if (p != getParent(parent, v)) {
                    b = false;
                }
            }
        }
        System.out.println(b ? "YES" : "NO");
    }

    static int getParent(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
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
