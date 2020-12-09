package kakaoblind.b2018.p4;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(
                        1, 1, 5, new String[] {
                                "08:01", "08:01", "08:02", "08:03"
                        }
                )
        );
    }

    public String solution2(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> waitQueue = new PriorityQueue<>();
        for (String time : timetable) {
            waitQueue.offer(timeToMinute(time));
        }

        int time = timeToMinute("09:00") - t;
        int lastPersonTime = 0;
        int lastRemain = 0;

        for (int i = 0; i < n; i++) {
            time += t;

            int remain = m;
            while (remain > 0 && !waitQueue.isEmpty() && waitQueue.peek() <= time) {
                remain--;
                lastPersonTime = waitQueue.poll();
            }
            if (i == n - 1) {
                lastRemain = remain;
            }
        }
        return lastRemain > 0 ? minuteToTime(time) : minuteToTime(lastPersonTime - 1);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> waitQueue = new PriorityQueue<>();
        for (String time : timetable) {
            waitQueue.offer(timeToMinute(time));
        }

        int time = timeToMinute("09:00") - t;
        for (int i = 0; i < n - 1; i++) {
            time += t;
            if (waitQueue.isEmpty()) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (waitQueue.peek() <= time) {
                    waitQueue.poll();
                }
                if (waitQueue.isEmpty()) {
                    break;
                }
            }
        }
        // last shuttle
        time += t;
        if (waitQueue.isEmpty()) {
            return minuteToTime(time);
        }
        int remain = m;
        int lastPersonTime = 0;

        while (remain > 0 && !waitQueue.isEmpty() && waitQueue.peek() <= time) {
            remain--;
            lastPersonTime = waitQueue.poll();
        }
        return remain > 0 ? minuteToTime(time) : minuteToTime(lastPersonTime - 1);
    }

    public String minuteToTime(Integer minutes) {
        StringBuilder sb = new StringBuilder(5);
        int hour = minutes / 60;
        if (hour < 10) {
            sb.append(0);
        }
        sb.append(hour).append(':');
        int minute = minutes % 60;
        if (minute < 10) {
            sb.append(0);
        }
        return sb.append(minute).toString();
    }

    public Integer timeToMinute(String time) {
        int ret = Integer.parseInt(time.substring(0, 2)) * 60;
        ret += Integer.parseInt(time.substring(3));
        return ret;
    }
}
