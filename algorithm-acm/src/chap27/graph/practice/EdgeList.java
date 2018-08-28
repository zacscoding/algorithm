package chap27.graph.practice;

import java.util.Arrays;
import java.util.List;

/**
 * @author zacconding
 * @Date 2018-08-28
 * @GitHub : https://github.com/zacscoding
 */
public class EdgeList {

    static final int numOfVertex = 6;
    static List<Pair> connected;
    static int[][] adj = new int[numOfVertex + 1][numOfVertex + 1];
    static int[][] e;

    public static void main(String[] args) {
        makeGraph();
        makeEdgeList();
        countEdgeList1();
        countEdgeList2();

        /*for(int i=0; i<e.length; i++) {
            System.out.printf("%d :: %d - %d\n", i, e[i][0], e[i][1]);
        }*/
    }

    private static void makeGraph() {
        connected = Arrays.asList(
            new Pair(1,2),
            new Pair(1,5),
            new Pair(2,3),
            new Pair(2,4),
            new Pair(2,5),
            new Pair(3,4),
            new Pair(4,5),
            new Pair(4,6)
        );

        for (Pair pair : connected) {
            adj[pair.n1][pair.n2] = adj[pair.n2][pair.n1] = 1;
        }
    }

    private static void makeEdgeList() {
        e = new int[connected.size() * 2][2];
        int edgeListIdx = 0;
        for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj[i].length; j++) {
                if (i != j && adj[i][j] == 1) {
                    e[edgeListIdx][0] = i;
                    e[edgeListIdx][1] = j;
                    edgeListIdx++;
                }
            }
        }
    }

    private static void countEdgeList1() {
        int[] cnt = new int[numOfVertex + 1];
        for (int i = 0; i < e.length; i++) {
            cnt[e[i][0]]++;
        }
        System.out.println("i번째 vertex에 연결 된 간선 수 ::");
        System.out.println(Arrays.toString(cnt));
    }

    private static void countEdgeList2() {
        int[] cnt = new int[numOfVertex + 1];
        for (int i = 0; i < e.length; i++) {
            cnt[e[i][0]]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = cnt[i - 1] + cnt[i];
        }

        for (int i = 1; i < cnt.length; i++) {
            System.out.printf("%d번 정점 in E : %d <= x <= %d\n", i, cnt[i - 1], (cnt[i] - 1));
            System.out.printf("==> E[%d] = %d, E[%d] = %d\n\n", cnt[i - 1], e[cnt[i - 1]][0], (cnt[i] - 1), e[(cnt[i] - 1)][0]);
        }
    }


    private static class Pair {
        private int n1;
        private int n2;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }
}