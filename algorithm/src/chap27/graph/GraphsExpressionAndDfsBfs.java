package chap27.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphsExpressionAndDfsBfs {
    public static int[][] adj;
    public static List<List<Integer>> adj2;
    public static boolean[] visited = new boolean[6];
    public static boolean[] visited2 = new boolean[6];
    
    public static void main(String[] args) {
        init();
        System.out.println("--- dfs By Array ---");
        dfsByArray(0);
        initVisited();
        System.out.println("--- bfs By Array ---");
        bfsByArray();
        initVisited();
        System.out.println("--- dfs By List ---");
        dfsByList(0);
        initVisited();
        System.out.println("--- bfs By List ---");
        bfsByList();
    }
    
    public static void init() {
        // init array
        adj = new int[][] {
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0}            
        };
        
        // init list
        adj2 = new ArrayList<>(6);
        for(int i=0; i<adj.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<adj[i].length; j++) {
                if(adj[i][j] == 1) {                    
                    list.add(j);                    
                }
            }
            adj2.add(list);
        }
    }
    
    public static void initVisited() {
        for(int i=0; i<visited.length; i++) {
            visited[i] = false;
            visited2[i] = false;
        }
    }
    
    
    /*      DFS     */
    // array
    public static void dfsByArray(int x) {
        visited[x] = true;        
        System.out.println("visit :: " + (x + 1) );
        
        for(int i=0; i<adj[x].length; i++) {
            if( (adj[x][i] == 1) && (!visited[i])) {
                dfsByArray(i);
            }
        }                
    }
    
    // list
    public static void dfsByList(int x) {
        visited2[x] = true;
        System.out.println("visit :: " + (x+1));
        for(int i=0; i<adj2.get(x).size(); i++) {
            int there = adj2.get(x).get(i);
            if(!visited2[there]) {
                dfsByList(there);
            }
        }
    }
    
    /*      BFS     */
    // array
    public static void bfsByArray() {
        Queue<Integer> q = new LinkedList<Integer>();
        visited[0] = true;
        q.offer(0);
        
        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.println("visit :: " + (x+1));
            
            for(int i=0; i<adj[x].length; i++) {
                if(adj[x][i] == 1 && !visited[i]) {
                    visited[i] =  true;
                    q.offer(i);
                }
            }            
        }        
    }
    
    // list
    public static void bfsByList() {
        Queue<Integer> q = new LinkedList<Integer>();
        visited2[0] = true;
        q.offer(0);
        
        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.println("visit :: " + (x+1));
            for(int i=0; i<adj2.get(x).size(); i++) {
                int there = adj2.get(x).get(i);
                if(!visited2[there]) {
                    visited2[there] = true;
                    q.offer(there);
                }
            }
        }
    }
}
