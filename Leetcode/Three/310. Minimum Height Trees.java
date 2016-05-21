public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 2) {
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i < n; ++i) {
                result.add(i);
            }
            return result;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        //---------------------------------//
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < graph.size(); ++i) {
            if(graph.get(i).size() == 1) {
                queue.add(i);
            }
        }
        //--------------------------------//
        while(n > 2) {
            int size = queue.size();
            n-=size;
            for(int i = 0; i < size; ++i) {
                int node = queue.poll();
                for(int next : graph.get(node)) {
                    degree[next]--;
                    degree[node]--;
                    if(degree[next] == 1) {
                        queue.add(next);
                    }
                }
            }
        }
        return new ArrayList<Integer>(queue);
    }
}
