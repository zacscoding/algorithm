package stack.p42583;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
class Solution {

    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        que.offer(3);
        que.offer(5);
        System.out.println(que.peek());
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // setup
        Queue<Truck> waitQueue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            waitQueue.offer(new Truck(truck_weight, bridge_length));
        }

        Queue<Truck> crossQueue = new LinkedList<>();
        crossQueue.offer(waitQueue.poll());

        int t = 0;
        int curWeight = crossQueue.peek().weight;

        while (!crossQueue.isEmpty()) {
            t++;
            if (curWeight + waitQueue.peek().weight <= bridge_length) {
                crossQueue.offer(waitQueue.poll());
            }

            Iterator<Truck> iterator = crossQueue.iterator();
            while (iterator.hasNext()) {
                Truck truck = iterator.next();
                truck.distance -= 1;
            }
        }

        int answer = 0;
        return answer;
    }

    static class Truck {
        int weight;
        int distance;

        public Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }
}