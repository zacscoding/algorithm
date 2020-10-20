package algorithm.easy.p234;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1,3, 2, 1 };
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        System.out.println(
                new Solution1().isPalindrome_Runner(head)
        );
    }

    public boolean isPalindrome_Deque(ListNode head) {
        if (head == null) {
            return true;
        }
        Deque<Integer> que = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            que.addLast(cur.val);
            cur = cur.next;
        }

        while (que.size() > 1) {
            if (!que.pollFirst().equals(que.pollLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_Runner(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head, slow = head, rev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = rev;
            rev = slow;
            slow = temp;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (rev != null) {
            if (rev.val != slow.val) {
                return false;
            }
            rev = rev.next;
            slow = slow.next;
        }
        return true;
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
