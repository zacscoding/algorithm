package chap08.dp.p2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2011
 *
 * @author zacconding
 * @Date 2018-12-13
 * @GitHub : https://github.com/zacscoding
 */
public class Try1 {

    static final int mod = 1000000;
    static String input;
    static Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws Exception {
        /*for (int i = 299; i < 300; i++) {
            String input = String.valueOf(i);
            System.out.printf("input : %s > %d\n", input, get(input));
        }*/
        Reader.init(System.in);
        input = Reader.next();
        System.out.println(get(input));
    }

    static int get(String input) {
        Integer value = dp.get(input);
        if (value != null) {
            return value;
        }

        if (input.length() == 1) {
            dp.put(input, Integer.valueOf(1));
            return 1;
        }

        if (input.length() == 2) {
            if (input.compareTo("10") < 0) {
                dp.put(input, Integer.valueOf(0));
                return 0;
            } else if (input.compareTo("27") < 0) {
                if (isNumber(input.charAt(0)) && isNumber(input.charAt(1))) {
                    dp.put(input, Integer.valueOf(2));
                    return 2;
                } else {
                    dp.put(input, Integer.valueOf(1));
                    return 1;
                }
            } else {
                dp.put(input, 1);
                return 1;
            }
        }

        int ret = 0;
        ret += get(input.substring(1)) % mod;

        if (input.charAt(0) == '1') {
            ret += get(input.substring(2)) % mod;
        } else if (input.charAt(0) == '2' && input.charAt(1) <= '6') {
            ret += get(input.substring(2)) % mod;
        }

        dp.put(input, ret);
        return ret;
    }

    static boolean isNumber(char ch) {
        return ch >= '1' && ch <= '9';
    }

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static {
            Reader.init(System.in);
        }

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
