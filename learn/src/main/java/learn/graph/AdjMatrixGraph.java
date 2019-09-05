package learn.graph;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import learn.io.Reader;

/**
 * Adjacency matrix
 *
 * @GitHub : https://github.com/zacscoding
 */
public class AdjMatrixGraph {

    static String input = "5 4\n"
                          + "0 1\n"
                          + "1 2\n"
                          + "2 3\n"
                          + "3 4";
    static int n, m;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        Reader.init(System.in);
        // Setup graph
        n = Reader.nextInt();
        m = Reader.nextInt();
        graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            int v1 = Reader.nextInt();
            int v2 = Reader.nextInt();

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        handleGraph();
    }

    static void handleGraph() {
        System.out.println("## Check graph");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; ) {
            int v1 = new Random().nextInt(n);
            int v2 = new Random().nextInt(n);
            if (v1 == v2) {
                continue;
            }
            i++;
            System.out.printf("Connected [%d,%d] = %s\n", v1, v2, graph[v1][v2] == 1);
        }

    }
}
