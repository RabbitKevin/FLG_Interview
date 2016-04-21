import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
/*
    You are given a graph and a node in the graph. Group the nodes connected to this node if they are also connected to each other.
    For example, the graph has nodes 1, 2, 3, 4, 5 where 1 is connected to 2, 3, 4; 2 and 3 are also connected to each other,
    4 is just connected to 1 and 5 is a separate node. You are given node 1 as input.
    Output should be:
    2 3
    4
*/
class Solution {
    public static void main(String[] args) {
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < 6; ++i) {
            graph.add(new HashSet<Integer>());
        }
        //-----------------//
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(1);
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(4).add(1);
        graph.get(4).add(2);
        graph.get(4).add(3);
        //-----------------//
        List<List<Integer>> result = help(graph, 1);
        for(int i = 0; i < result.size(); ++i) {
            System.out.println(result.get(i));
        }
    }
    public static List<List<Integer>> help(List<Set<Integer>> graph, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> nodes = graph.get(target);
        HashSet<Integer> remainNode = new HashSet<>(nodes);//nodes will be group
        //-----------------------------------//
        if(nodes.size() == 0) return result;//no adj nodes
        for(int node : nodes) {
            if(remainNode.contains(node)) {
                List<Integer> group = new ArrayList<Integer>();
                group.add(node);
                remainNode.remove(node);
                dfs(nodes, remainNode, group, graph);
                result.add(group);
            }
        }
        return result;
    }
    /*

    */
    public static void dfs(Set<Integer> nodes, Set<Integer> remainNode, List<Integer> result, List<Set<Integer>> graph) {
        for(int num : nodes) {
            if(!remainNode.contains(num)) continue;
            Set<Integer> adj = graph.get(num);
            for(int tmp : result) {
                if(!adj.contains(tmp)) return;
            }
            remainNode.remove(num);
            result.add(num);
            dfs(nodes, remainNode, result, graph);
        }
    }
}
