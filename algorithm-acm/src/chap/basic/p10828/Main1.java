package chap.basic.p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class Main1 {

    static IntegerStack stack = new IntegerStack(10000);
    static int N;

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        N = Reader.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String cmd = Reader.next();
            switch (cmd) {
                case "push":
                    stack.push(Reader.nextInt());
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static class IntegerStack {

        Integer[] elementData;
        int elementCount;

        IntegerStack(int capacity) {
            elementData = new Integer[capacity];
        }

        public void push(int elt) {
            // check capacity
            ensureCapacity();
            elementData[elementCount++] = elt;
        }

        public int pop() {
            if (elementCount == 0) {
                return -1;
            }

            int ret = elementData[elementCount - 1];
            elementData[elementCount--] = null;
            return ret;
        }

        public int size() {
            return elementCount;
        }

        public boolean empty() {
            return elementCount == 0;
        }

        public int top() {
            return elementCount == 0 ? -1 : elementData[elementCount - 1];
        }

        private void ensureCapacity() {
            if (elementCount != elementData.length) {
                return;
            }

            int missingIdx = elementCount + 1;
            int length = Math.max(10, (int) (missingIdx * 1.2D));
            Integer[] newElementData = new Integer[length];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);

            Integer[] temp = elementData;
            elementData = newElementData;
            temp = null;
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
