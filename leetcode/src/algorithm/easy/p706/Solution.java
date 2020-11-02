package algorithm.easy.p706;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 2);
        System.out.println(obj.get(1));
        obj.put(1, 3);
        System.out.println(obj.get(1));
        obj.remove(1);
        System.out.println(obj.get(1));
    }
}

/**
 * https://leetcode.com/problems/design-hashmap/
 */
class MyHashMap {

    private List<Node>[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new List[1000000 / 10];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashValue = hash(key);

        List<Node> nodeList = nodes[hashValue];

        if (nodeList != null) {
            for (Node node : nodeList) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }
        } else {
            nodeList = new LinkedList<>();
            nodes[hashValue] = nodeList;
        }
        nodeList.add(new Node(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashValue = hash(key);

        List<Node> nodeList = nodes[hashValue];
        if (nodeList == null) {
            return -1;
        }

        for (Node node : nodeList) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashValue = hash(key);

        List<Node> nodeList = nodes[hashValue];
        if (nodeList == null) {
            return;
        }
        Iterator<Node> itr = nodeList.iterator();
        while (itr.hasNext()) {
            Node node = itr.next();
            if (node.key == key) {
                itr.remove();
                return;
            }
        }
    }

    private int hash(int key) {
        return key % nodes.length;
    }

    static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
