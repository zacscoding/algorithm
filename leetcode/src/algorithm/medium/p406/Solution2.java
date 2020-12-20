package algorithm.medium.p406;

import java.util.*;

import algorithm.util.Printer;

public class Solution2 {
    public static void main(String[] args) {
        int[][] answer = new Solution2().reconstructQueue(new int[][] {
                { 7, 0 },
                { 4, 4 },
                { 7, 1 },
                { 5, 0 },
                { 6, 1 },
                { 5, 2 },
                });
        for (int i = 0; i < answer.length; i++) {
            Printer.out("[%d, %d]", answer[i][0], answer[i][1]);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        List<People> peopleList = new ArrayList<>(people.length);
        for (int i = 0; i < people.length; i++) {
            peopleList.add(new People(people[i][0], people[i][1]));
        }
        Collections.sort(peopleList, (p1, p2) -> {
            int dh = p1.h - p2.h;
            if (dh != 0) {
                return -dh;
            }
            return p1.k - p2.k;
        });

        List<People> answer = new ArrayList<>(people.length);
        for (People p : peopleList) {
            answer.add(p.k, p);
        }
        for (int i = 0; i < answer.size(); i++) {
            People p = answer.get(i);
            people[i][0] = p.h;
            people[i][1] = p.k;
        }
        return people;
    }

    static class People {
        int h;
        int k;

        public People(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }
}
