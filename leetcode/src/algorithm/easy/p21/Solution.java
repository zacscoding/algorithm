package algorithm.easy.p21;

public class Solution {

    public static void main(String[] args) {
        ListNode left = new ListNode(1,
                                     new ListNode(2,
                                                  new ListNode(4)));
        ListNode right = new ListNode(1,
                                      new ListNode(3,
                                                   new ListNode(4)));

        ListNode n = new Solution().mergeTwoLists(left, right);
        ListNode next = n;
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            ListNode temp = null;
            if (p1.val <= p2.val) {
                temp = p1;
                p1 = p1.next;
            } else {
                temp = p2;
                p2 = p2.next;
            }
            tail.next = temp;
            tail = tail.next;
        }

        if (p1 != null) {
            tail.next = p1;
        } else {
            tail.next = p2;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
