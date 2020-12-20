package algorithm.medium.p621;

import java.util.*;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class Solution {
    // ["A","A","A","B","B","B", "C","C","C", "D", "D", "E"]
    //2
    public static void main(String[] args) {
        System.out.println(
                new Solution().leastInterval(
                        new char[] { 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E' },
                        2)
        );
    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Task> map = new HashMap<>();
        for (char taskCh : tasks) {
            Task task = map.get(taskCh);
            if (task == null) {
                task = new Task(taskCh, 0);
                map.put(taskCh, task);
            }
            task.count++;
        }

        PriorityQueue<Task> que = new PriorityQueue<>(map.values());
        int unit = 0;

        while (!que.isEmpty()) {
            List<Task> temp = new ArrayList<>(que.size());
            for (int i = 0; i <= n; i++) {
                if (que.isEmpty()) {
                    if (temp.isEmpty()) {
                        break;
                    }
                    // idle
                    unit++;
                    continue;
                }
                Task t = que.poll();
                t.count--;
                unit++;
                if (t.count > 0) {
                    temp.add(t);
                }
            }
            que.addAll(temp);
        }
        return unit;
    }

    static class Task implements Comparable<Task> {
        char ch;
        int count;

        public Task(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Task o) {
            return -(count - o.count);
        }
    }
}
