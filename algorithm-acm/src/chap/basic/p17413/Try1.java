package chap.basic.p17413;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/17413
 */
public class Try1 {

    public static void main(String[] args) throws IOException {
        String data = "one1 two2 three3 4fourr 5five 6six";
        InputStream stream = new ByteArrayInputStream(data.getBytes());
        System.setIn(stream);
        Reader.init(System.in);

        char[] line = Reader.nextLine().toCharArray();
        StringBuilder answer = new StringBuilder(line.length);

        boolean reverse = true;

        for (int i = 0; i < line.length; i++) {
            char ch = line[i];

            if (ch == '<') {
                answer.append(ch);
                reverse = false;
            } else if (ch == '>') {
                answer.append(ch);
                reverse = true;
            } else {
                if (!reverse) {
                    answer.append(ch);
                } else {
                    int target = line.length - 1;

                    boolean whiteSpaceOrStart = false;

                    for (int j = i; j < line.length; j++) {
                        char ch2 = line[j];

                        if (ch2 == ' ') {
                            target = j;
                            whiteSpaceOrStart = true;
                            break;
                        } else if (ch2 == '<') {
                            target = j;
                            reverse = false;
                            whiteSpaceOrStart = true;
                            break;
                        }
                    }

                    if (!whiteSpaceOrStart) {
                        answer.append(line[target]);
                    }

                    for (int j = target - 1; j >= i; j--) {
                        answer.append(line[j]);
                    }

                    if (whiteSpaceOrStart) {
                        answer.append(line[target]);
                    }

                    i = target;
                }
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
