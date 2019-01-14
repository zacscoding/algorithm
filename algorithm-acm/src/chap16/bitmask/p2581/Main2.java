package chap16.bitmask.p2581;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2581
 */
public class Main2 {

    static int M, N;
    static short[] sieve = new short[(10001 + 7) / 8];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        M = Reader.nextInt();
        N = Reader.nextInt();

        for (int i = 0; i < sieve.length; i++) {
            sieve[i] = Short.MAX_VALUE;
        }

        setComposite(0);
        setComposite(1);
        int sqrtn = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrtn; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j <= N; j += i) {
                    setComposite(j);
                }
            }
        }

        boolean first = false;
        int firstPrime = -1;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;
                if (first == false) {
                    firstPrime = i;
                    first = true;
                }
            }
        }

        if (sum != 0) {
            System.out.println(sum);
        }
        System.out.println(firstPrime);
    }

    static boolean isPrime(int k) {
        // k/8번째 원소의 k%8 번째 비트가 켜져 있는지 확인
        return (sieve[k >> 3] & (1 << (k & 7))) != 0;
    }

    static void setComposite(int k) {
        // sieve[k >> 3] &= ~(1 << (k & 7));
        sieve[k >> 3] &= ~(1 << (k & 7));
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
