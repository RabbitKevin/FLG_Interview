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
    private static void topology_dfs(List<List<Integer>> graph) {
        Stack<Integer> nodes = new Stack<>();
        boolean[] isVisited = new boolean[graph.size()];
        for(int i = 0; i < graph.size(); ++i) {
            if(isVisited[i]) continue;
            dfs(i, graph, isVisited, nodes);
        }
        while(!nodes.isEmpty()) {
            System.out.print(nodes.pop());
            System.out.print(" ");
        }
        System.out.println();
    }
    private static void dfs(int i, List<List<Integer>> graph, boolean[] isVisited, Stack<Integer> nodes) {
        isVisited[i] = true;
        List<Integer> adjs = graph.get(i);
        for(int index : adjs) {
            if(!isVisited[index]) dfs(index, graph, isVisited, nodes);
        }
        nodes.push(i);
    }
    private static void topology_bfs(List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> nodes = new Stack<>();
        List<Integer> result = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.size()];
        for(int i = 0; i < graph.size(); ++i) {
            if(isVisited[i]) continue;
            queue.add(i);
            isVisited[i] = true;
            while(!queue.isEmpty()) {
                int node = queue.poll();
                for(int adj : graph.get(node)) {
                    if(!isVisited[adj]) {
                        queue.add(adj);
                        isVisited[adj] = true;
                    }
                }
                nodes.push(node);
            }
            while(!nodes.isEmpty()) {
                result.add(0,nodes.pop());
            }
        }
        for(int val : result) {
            System.out.print(val);
            System.out.print(" ");
        }
        System.out.println();
    }
}
