package demo.javainterview.p9;

import java.util.Deque;
import java.util.LinkedList;

public class TrainComposition {

    private Deque<Integer> que = new LinkedList<>();

    public void attachWagonFromLeft(int wagonId) {
        que.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        que.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        return que.removeFirst();
    }

    public int detachWagonFromRight() {
        return que.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}