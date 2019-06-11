package chap.basic.p1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1021
 */
public class Main {

    static int N, M;
    static int[] finds;
    static List<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        N = Reader.nextInt();
        M = Reader.nextInt();
        finds = new int[M];
        for (int i = 0; i < M; i++) {
            finds[i] = Reader.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;
        for (int i = 0; i < finds.length; i++) {
            Integer find = finds[i];
            int idx = queue.indexOf(find);
            if (idx != 0) {
                int op3Count = queue.size() - idx;
                if (idx > op3Count) { // op2
                    for (int j = 0; j < op3Count; j++) {
                        op2();
                        count++;
                    }
                } else {// op3
                    for (int j = 0; j < idx; j++) {
                        op3();
                        count++;
                    }
                }
            }
            op1();
        }
        System.out.println(count);
    }

    static void display() {
        for (int i = 0; i < queue.size(); i++) {
            System.out.printf(queue.get(i) + " ");
        }
        System.out.println();
    }

    static void op1() {
        queue.remove(0);
    }

    static void op2() {
        Integer last = queue.remove(queue.size() - 1);
        queue.add(0, last);
    }

    static void op3() {
        Integer first = queue.remove(0);
        queue.add(first);
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
