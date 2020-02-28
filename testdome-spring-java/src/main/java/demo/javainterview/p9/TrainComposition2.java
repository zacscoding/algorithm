package demo.javainterview.p9;

public class TrainComposition2 {

    Node first;
    Node last;

    public void attachWagonFromLeft(int wagonId) {
        final Node f = first;
        final Node newFirst = new Node(wagonId, null, f);

        if (f == null) {
            last = newFirst;
        } else {
            f.prev = newFirst;
        }

        first = newFirst;
    }

    public void attachWagonFromRight(int wagonId) {
        final Node l = last;
        final Node newLast = new Node(wagonId, l, null);

        if (l == null) {
            first = newLast;
        } else {
            l.next = newLast;
        }

        last = newLast;
    }

    public int detachWagonFromLeft() {
        final Node f = first;

        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }

        return f.wagonId;
    }

    public int detachWagonFromRight() {
        final Node l = last;

        if (last.prev == null) {
            first = null;
            last = null;
        } else {
            last = last.prev;
        }

        return l.wagonId;
    }

    static class Node {
        int wagonId;
        Node prev;
        Node next;

        public Node(int wagonId, Node prev, Node next) {
            this.wagonId = wagonId;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}