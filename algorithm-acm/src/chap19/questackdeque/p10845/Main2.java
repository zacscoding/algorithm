package chap19.questackdeque.p10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10845
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int N = Reader.nextInt();
        ArrayListQueue<Integer> que = new ArrayListQueue<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String cmd = Reader.next().trim();
            switch (cmd) {
                case "push":
                    int elt = Reader.nextInt();
                    que.push(elt);
                    break;
                case "pop":
                    answer.append(que.pop(-1))
                        .append('\n');
                    break;
                case "size":
                    answer.append(que.size())
                        .append('\n');
                    break;
                case "empty":
                    answer.append(que.isEmpty() ? 1 : 0)
                        .append('\n');
                    break;
                case "front":
                    answer.append(que.isEmpty() ? -1 : que.getFirst())
                        .append('\n');
                    break;
                case "back":
                    answer.append(que.isEmpty() ? -1 : que.getLast())
                        .append('\n');
                    break;
            }
        }
        System.out.println(answer);
    }

    static class ArrayListQueue<E> {

        private Object[] elts = new Object[4];
        private int head = 0;
        private int tail = -1;
        private int size = 0;

        // addLast
        public void push(E e) {
            ensureCapacity(size + 1);
            tail = (tail + 1) % elts.length;
            elts[tail] = e;
            ++size;
        }

        // removeFirst
        public E pop() {
            return pop(null);
        }

        // removeFirst or default elts
        public E pop(E defaultElement) {
            if (size == 0) {
                return defaultElement;
            }

            --size;
            E ret = (E) elts[head];
            elts[head] = null;
            head = (head + 1) % elts.length;
            return ret;
        }

        public E getFirst() {
            return size == 0 ? null : (E) elts[head];
        }

        public E getLast() {
            return size == 0 ? null : (E) elts[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        private void ensureCapacity(int capacity) {
            if (capacity - elts.length > 0) {
                int oldCapacity = elts.length;
                int delta = (oldCapacity >> 1);
                int newCapacity = oldCapacity + delta;

                if (newCapacity - capacity < 0) {
                    newCapacity = capacity;
                }

                Object[] newElts = new Object[newCapacity];
                // arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
                // copy 0~ tail
                System.arraycopy(elts, 0, newElts, 0, tail + 1);
                if (tail < head) {
                    // copy head ~ length -1
                    System.arraycopy(elts, head, newElts, head + delta, elts.length - head);
                    head += delta;
                }
                elts = newElts;
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
