package chap27.graph.p2331;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2331
 *
 * @author zaccoding
 * github : https://github.com/zacscoding
 */
public class MainByDP {

    public static int P, A;
    static Map<Integer, Integer> dp = new HashMap<>(11000, 0.999999f);

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        A = Reader.nextInt();
        P = Reader.nextInt();
        int idx = 1;
        if (!dp.isEmpty()) {
            dp.clear();
        }

        dp.put(A, idx++);
        int next = A;
        int answer = 0;
        while (true) {
            next = next(next, P);
            Integer exist = dp.get(next);
            if (exist != null) {
                answer = exist - 1;
                break;
            } else {
                dp.put(next, idx++);
            }
        }

        System.out.println(answer);
    }

    public static int next(int n, int p) {
        String stringVal = String.valueOf(n);
        int answer = 0;
        for (int i = 0; i < stringVal.length(); i++) {
            answer += Math.pow((stringVal.charAt(i) - '0'), p);
        }
        return answer;
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
