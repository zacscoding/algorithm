package learn.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @GitHub : https://github.com/zacscoding
 */
public class Reader {
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
