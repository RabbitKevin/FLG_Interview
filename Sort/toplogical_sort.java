import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        //----Construct graph----//
        int v = 5;
        for(int i = 0; i <= v; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(1).add(5);
        graph.get(1).add(4);
        graph.get(0).add(5);
        graph.get(0).add(2);
        //-----------------//
        //topology_dfs(graph);
        topology_bfs(graph);
    }
}
