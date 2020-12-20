package algorithm.medium.p332;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import algorithm.util.Printer;

public class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().findItinerary(
                        Arrays.asList(
//                                Arrays.asList("MUC", "LHR"),
//                                Arrays.asList("JFK", "MUC"),
//                                Arrays.asList("SFO", "SJC"),
//                                Arrays.asList("LHR", "SFO")
                                //
//                                Arrays.asList("JFK", "SFO"),
//                                Arrays.asList("JFK", "ATL"),
//                                Arrays.asList("SFO", "ATL"),
//                                Arrays.asList("ATL", "JFK"),
//                                Arrays.asList("ATL", "SFO")
                                Arrays.asList("JFK", "KUL"),
                                Arrays.asList("JFK", "NRT"),
                                Arrays.asList("NRT", "JFK")
                        )
                ).stream().collect(Collectors.joining(","))

        );
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adjMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            List<String> adjList = adjMap.computeIfAbsent(from, k -> new ArrayList<>());
            adjList.add(to);
        }
        for (List<String> v : adjMap.values()) {
            Collections.sort(v);
        }
        List<String> answer = new ArrayList<>(tickets.size() + 1);
        dfs(adjMap, answer, "JFK", tickets.size() + 1);
        return answer;
//        for (Entry<String, List<String>> entry : adjMap.entrySet()) {
//            Printer.out("[%s] - %s", entry.getKey(), entry.getValue().stream().collect(Collectors.joining(",")));
//        }
    }

    public void dfs(Map<String, List<String>> adjMap, List<String> path, String current, int require) {
        path.add(current);
        if (path.size() == require) {
            return;
        }

        List<String> adjList = adjMap.get(current);
        if (adjList == null) {
            path.remove(path.size() - 1);
            return;
        }
        for (int i = 0; i < adjList.size(); i++) {
            String next = adjList.remove(i);
            dfs(adjMap, path, next, require);
            if (path.size() == require) {
                return;
            }
            adjList.add(i, next);
        }
        path.remove(path.size() - 1);
    }
}
