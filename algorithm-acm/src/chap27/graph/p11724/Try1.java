package chap27.graph.p11724;

import java.io.*;
import java.util.*;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/11724
 */
public class Try1 {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();
        int m = Reader.nextInt();

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            union(parent, Reader.nextInt(), Reader.nextInt());
        }

        Set<Integer> set = new HashSet<>((int) (n * 1.2), 0.99999f);

        for (int i = 1; i <= n; i++) {
            set.add(find(parent, i));
        }

        System.out.println(set.size());
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a == b) {
            return;
        }

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
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
