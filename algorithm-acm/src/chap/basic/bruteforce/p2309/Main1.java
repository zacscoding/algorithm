package chap.basic.bruteforce.p2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2309
 */
public class Main1 {

    public static void main(String[] args) throws IOException {
//        String data = "20\n"
//                      + "7\n"
//                      + "23\n"
//                      + "19\n"
//                      + "10\n"
//                      + "15\n"
//                      + "25\n"
//                      + "8\n"
//                      + "13";
//        InputStream stream = new ByteArrayInputStream(data.getBytes());
//        System.setIn(stream);
        Reader.init(System.in);

        int sum = 0;
        int not1 = -1, not2 = -1;
        int[] n = new int[9];

        for (int i = 0; i < 9; i++) {
            n[i] = Reader.nextInt();
            sum += n[i];
        }

        Arrays.sort(n);

        A:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum2 = sum - n[i] - n[j];

                if (sum2 == 100) {
                    not1 = i;
                    not2 = j;
                    break A;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != not1 && i != not2) {
                System.out.println(n[i]);
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
