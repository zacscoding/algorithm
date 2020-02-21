package graph.p43164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
class Failure {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Failure().solution(new String[][] {
                        { "ICN", "JFK" },
                        { "HND", "IAD" },
                        { "JFK", "HND" }
                })
        ));

        System.out.println(Arrays.toString(
                new Failure().solution(new String[][] {
                        { "ICN", "SFO" },
                        { "ICN", "ATL" },
                        { "SFO", "ATL" },
                        { "ATL", "ICN" },
                        { "ATL", "SFO" }
                })
        ));
    }

    public String[] solution(String[][] tickets) {
        List<String> cities = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            String c1 = tickets[i][0];
            String c2 = tickets[i][1];

            if (cities.indexOf(c1) < 0) {
                cities.add(c1);
            }

            if (cities.indexOf(c2) < 0) {
                cities.add(c2);
            }
        }
        Collections.sort(cities);

        int[][] g = new int[cities.size()][cities.size()];

        for (int i = 0; i < tickets.length; i++) {
            g[cities.indexOf(tickets[i][0])][cities.indexOf(tickets[i][1])] = 1;
        }

        int start = cities.indexOf("ICN");
        List<String> answers = new ArrayList<>(cities.size());

        visit(cities, g, start, answers);

        String[] answersArr = new String[answers.size()];
        answers.toArray(answersArr);
        return answersArr;
    }

    void visit(List<String> cities, int[][] g, int v, List<String> answers) {
        answers.add(cities.get(v));

        for (int i = 0; i < g[v].length; i++) {
            if (g[v][i] == 1) {
                g[v][i] = 0;
                visit(cities, g, i, answers);
            }
        }
    }
}