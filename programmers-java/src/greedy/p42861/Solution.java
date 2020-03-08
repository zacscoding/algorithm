package greedy.p42861;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */
class Solution {

    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            que.offer(new Node(costs[i][0], costs[i][1], costs[i][2]));
        }

        int edges = n - 1;
        int answer = 0;

        while (!que.isEmpty()) {
            if (edges <= 0) {
                break;
            }

            Node node = que.poll();

            if (getParent(parent, node.v1) != getParent(parent, node.v2)) {
                union(parent, node.v1, node.v2);
                answer += node.cost;
                edges--;
            }
        }

        return answer;
    }

    int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    void union(int[] parent, int x, int y) {
        x = getParent(parent, x);
        y = getParent(parent, y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static class Node {
        int v1;
        int v2;
        int cost;

        public Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}