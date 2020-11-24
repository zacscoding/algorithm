package algorithm.medium.p148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode h = head;

        List<Integer> arr = new ArrayList<>();
        ListNode next = head;
        while (next != null) {
            arr.add(next.val);
            next = next.next;
        }

        Collections.sort(arr);
        next = head;
        for (int i = 0; i < arr.size(); i++) {
            next.val = arr.get(i);
            next = next.next;
        }
        return h;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
